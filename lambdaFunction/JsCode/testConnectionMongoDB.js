
"use strict";
const MongoClient = require('mongodb').MongoClient;
const MONGODB_URI = "mongodb+srv://server_user:server_password@profiling-88zkw.mongodb.net/test?retryWrites=true&w=majority"; // or Atlas connection string

let cachedDb = null;

function SendToAll(dataArray){
  var itemsProcessed = 0;

  var x = dataArray.forEach((item, index, array) => {
  SendToOne(item, () => {
    itemsProcessed++;
    if(itemsProcessed === array.length) {
      //return "ok";
    }
  })
})
  return x;
}


function SendToOne(dataUser){
  console.log(dataUser.userId)
  var aws = require('aws-sdk');
  var lambda = new aws.Lambda({
    region: 'us-east-1' //change to your region
  });

  lambda.invoke({
    FunctionName: 'computeRecommendationBasic',
    Payload: JSON.stringify({key1: dataUser.userId}) // pass params
    }, function(error, data) {
    if (error) {
      console.log(JSON.stringify(error));
    }
    if(data.Payload){    
      console.log(JSON.stringify(data.Payload));
    }
  });
  
}

function connectToDatabase (uri) {
  console.log('=> connect to database');

  
   return MongoClient.connect(uri, {useUnifiedTopology: true})
    .then(client => {
      cachedDb = client;
      return cachedDb;
    });
}
  
function queryClient (client) {
    console.log('=> query client');
    return client.db('test');
}

function queryDatabase (db) {
  console.log('=> init database');
  
  console.log('=> query database');
  return db.collection('User').find({}).toArray()
   .then(
     result => {//console.log("JE SUIS LA " , result);
     return result;});
}

module.exports.handler = (event, context, callback) => {
  context.callbackWaitsForEmptyEventLoop = false;

  connectToDatabase(MONGODB_URI)
    .then(client => queryClient(client))
    .then(db => queryDatabase(db))
    .then(result => SendToAll(result)
      //console.log('=> returning result: ', result);
     // callback(null, result);
    )
    .then(res => callback(null, res))
    .catch(err => {
      console.log('=> an error occurred: ', err);
      callback(err);
    });
};
