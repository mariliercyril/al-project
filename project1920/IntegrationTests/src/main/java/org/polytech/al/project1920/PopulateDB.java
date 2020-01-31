package org.polytech.al.project1920;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class PopulateDB {

    static MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://server_user:{NOT_THE_PASSWORD}@profiling-88zkw.mongodb.net/test?retryWrites=true&w=majority");

    static MongoClient mongoClient = new MongoClient(uri);
    static MongoDatabase database = mongoClient.getDatabase("test");

    static void populate(){
        List<Document> list = new ArrayList<>();
        for(int x=0;x<2;x++){
            Document a = new Document();
            a.append("userId","Laurent"+x);
            a.append("age",22*(1+x));
            a.append("money",8000.0*(1+x));
            a.append("password","nul");
            a.append("_class","org.polytech.al.project1920.useraccount.model.User");
            list.add(a);
        }
        database.getCollection("User").insertMany(list);
    }
}
