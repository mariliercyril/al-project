// Will return a subset of the product given in parameter. A delay has been added to mimic a real machine learning algo

//entrypoint of the lambda function
exports.handler = async (event, context, callback) => {
    var recomendationPossible = event.key1;
    var recomendationProcessed = [];
    
    recomendationPossible.forEach((item, index, array) => {
      var random_boolean = Math.random() >= 0.5;
      if (random_boolean){
          recomendationProcessed.push(item);
      }
    });
    
    sleep(5000); // done to mimic to processing of a real machine learning algo, it takes time to process
    console.log("result :" + recomendationProcessed);

    callback(null, recomendationProcessed);
};

function sleep(milliseconds) {
  const date = Date.now();
  let currentDate = null;
  do {
    currentDate = Date.now();
  } while (currentDate - date < milliseconds);
}