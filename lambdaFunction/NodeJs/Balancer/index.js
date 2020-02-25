// Will send a request to the compouter foir every user in the db

const MongoClient = require('mongodb').MongoClient;
const MONGODB_URI = "mongodb+srv://server_user:server_password@profiling-88zkw.mongodb.net/test?retryWrites=true&w=majority"; // connection string, ask noe for password

let cachedDb = null;

function SendToAll(users){
  var itemsProcessed = 0;
  var currentdate = new Date(); 
  var datetime = currentdate.getDate() + "/"
                  + (currentdate.getMonth()+1)  + "/" 
                  + currentdate.getFullYear() + " "  
                  + currentdate.getHours() + ":"  
                  + currentdate.getMinutes() + ":" 
                  + currentdate.getSeconds();

  var res = users.forEach((item, index, array) => {
  SendToOne(item,datetime, () => {
    itemsProcessed++;
    if(itemsProcessed === array.length) {
    }
  });
});
  return res;
}


function SendToOne(dataUser, datetime){
  console.log(JSON.stringify({key1: dataUser.userId}));

  var aws = require('aws-sdk');
  var lambda = new aws.Lambda({
    InvocationType: "Event" ,
    region: 'us-east-1' //change to your region
  });
  
  // call computer lambda
  lambda.invoke({
    FunctionName: 'computeRecomendationMachineLearning',
    Payload: JSON.stringify({key1: dataUser._id, key2: datetime, key3: staticProduct()}) // pass params
    }, function(error, data) {
    if (error) {
        console.log(dataUser.userId + JSON.stringify(error));
    }
    if(data.Payload){    
        console.log(dataUser.userId + JSON.stringify(data.Payload));
    }
    else{
      console.log(JSON.stringify(dataUser.userId));
    }
  });
  
}

function connectToMongoClient (uri) {
  console.log('=> connect to MongoClient, still need to connect to the right database inside ');
  
   return MongoClient.connect(uri, {useUnifiedTopology: true})
    .then(client => {
      cachedDb = client;
      return cachedDb;
    });
}


function staticConnectToDatabase(client) {
    // done statically as the method is called multiple time
    if( typeof staticConnectToDatabase.counter == 'undefined' ) {
        staticConnectToDatabase.counter = client.db('test'); // test is the name of our database
    }
    return staticConnectToDatabase.counter;
}

function staticProduct(product) {
    // done statically as the method is called multiple time
    if( typeof staticProduct.prod == 'undefined' ) {
        staticProduct.prod = product;
    }
    return staticProduct.prod;
}
  

function queryDatabaseUsers () {
  var db = staticConnectToDatabase();

  console.log('=> query database');
  return db.collection('User').find({}).toArray()
   .then(
     result => {
      return result;
     });
}



function queryDatabaseProduct () {
  var db = staticConnectToDatabase();
  
  console.log('=> query database');
  return db.collection('ProductStorageDB').find({}).toArray()
   .then(
     result => {
      staticProduct(result);
      return;
     });
}

//entrypoint of the lambda function
module.exports.handler = (event, context, callback) => {
  context.callbackWaitsForEmptyEventLoop = false;

  connectToMongoClient(MONGODB_URI) // connect to mongo client
    .then(client => staticConnectToDatabase(client)) // connect to the correct database inside the mongo client
    .then(queryDatabaseProduct()) // get all products
    .then(queryDatabaseUsers()) // get all users
    .then(users => {
      SendToAll(users); // send request to computer for each user
    });
};
