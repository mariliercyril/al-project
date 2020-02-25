// Will retrieve client data and call the machine learninig model to get a recomendation. Then it will write it in the database

const MongoClient = require('mongodb').MongoClient;
const MONGODB_URI = "mongodb+srv://server_user:server_password@profiling-88zkw.mongodb.net/test?retryWrites=true&w=majority"; // connection string, ask noe for password
const aws = require('aws-sdk');

let cachedDb = null;

function connectToMongoClient (uri) {
  console.log('=> connect to MongoClient');
  
   return MongoClient
   .connect(uri, {useUnifiedTopology: true})
    .then(client => {
      cachedDb = client;
      return cachedDb;
    });
}
  

async function staticConnectToDatabase(client) {
    if( typeof staticConnectToDatabase.counter == 'undefined' ) {
        staticConnectToDatabase.counter = await client.db('test');
        return staticConnectToDatabase.counter;
    }
    return staticConnectToDatabase.counter;
}

function queryDatabaseUser (db, user) {
    var mongo = require('mongodb');
    var o_id = new mongo.ObjectID(user);

    console.log('=> query database');
    return db.collection('User').findOne({"_id": o_id})
        .then(
            result => {
                return result;
            });
}

function callMachineLeanrningCluster(product, db){

    var products = [];
    product.forEach((item, index, array) => {
        products.push(item.product);
    });

    var lambda = new aws.Lambda({
              region: 'us-east-1' //change to your region
            });

            return lambda.invoke({
                FunctionName: 'mimicTrainingModel',
                Payload: JSON.stringify({key1: products}) // pass params
            }, function(error, data) {
            if (error) {
                console.log(JSON.stringify(error));
            }
            else if(data.Payload){
                console.log(JSON.stringify(data.Payload));
                return data.Payload;
            }
          }).promise(); // done as a premise as we need to wait for the return of the call
}

function addRecomendationDatabase (user, date, product) {
    console.log('=> updateDatabase');

    staticConnectToDatabase()
        .then(db => {

            var newRecomendation = {
                recommendation: JSON.parse(product),
                userID: user._id,
                _class: "org.polytech.al.project1920.useraccount.model.Recomendation"
            };
            console.log(JSON.stringify(date));
            // the collection depends on the date so we don't eraise previous recomendation
            return db.collection("Recomendation " + date).insertOne(newRecomendation, function(error, data){
                    if (error) {
                        console.log(JSON.stringify(error));
                    }
                    if(data){    
                        console.log(JSON.stringify(data));
                    }
                });
        });
    console.log('=> endUpdateDB');
}


//entrypoint of the lambda function
module.exports.handler = (event, context, callback) => {

  context.callbackWaitsForEmptyEventLoop = false;

  var user = event.key1;
  var date = event.key2;
  var product = event.key3;
  var recoComputeResult;

  callMachineLeanrningCluster(product) // call another lambda that will mimic the machine learning and return a result, we send only the products and not the user specificity as it is random anyway
    .then(res => {
        recoComputeResult = res.Payload;
        //console.log("tabReco :")
        //console.log(tabReco.Payload)
        return connectToMongoClient(MONGODB_URI);
    })
    .then(client => {
        //console.log("client :")
        //console.log(client)
        return staticConnectToDatabase(client);
    })
    .then(db => {
        //console.log("db :")
        //console.log(db)
        return queryDatabaseUser(db, user);
    })
    .then(user => {
        console.log("query :");
        //console.log(query)
        return addRecomendationDatabase(user, date, recoComputeResult);
    })
    .then(callback(null, null));
    return;
};
