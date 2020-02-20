package org.polytech.al.project1920;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopulateDB {

    static Logger root = (Logger) LoggerFactory
            .getLogger(Logger.ROOT_LOGGER_NAME);

    static {
        root.setLevel(Level.ERROR);
    }

    static MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://server_user:server_password@profiling-88zkw.mongodb.net/test?retryWrites=true&w=majority");

    static MongoClient mongoClient = new MongoClient(uri);
    static MongoDatabase database = mongoClient.getDatabase("test");

    static void populate(int newClients){
        Random random = new Random();
        List<Document> list = new ArrayList<>();
        for(int x=1;x<newClients+1;x++){
            Document a = new Document();
            a.append("userId","Client"+x);
            a.append("age",random.nextInt(85)+15);
            a.append("money",random.nextInt(100000)+100);
            a.append("password","nul");
            a.append("_class","org.polytech.al.project1920.useraccount.model.User");
            list.add(a);
        }
        database.getCollection("User").insertMany(list);
    }

    static void clear(){
        database.getCollection("User").drop();
    }

    static long countDatabase(String s){
        return database.getCollection(s).countDocuments();
    }
}
