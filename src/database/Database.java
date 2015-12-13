/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import org.bson.Document;

/**
 *
 * @author prabod
 */
public class Database {

    MongoClient mongoClient;
    MongoDatabase db;
    MongoCollection coll;

    public Database() {
        this.mongoClient = new MongoClient("localhost", 27017);
        this.db = mongoClient.getDatabase("SwimmingCompetition");
        this.coll = db.getCollection("Results");
        if (coll == null) {
            db.createCollection("Results");
            this.coll = db.getCollection("Results");
        }
    }

    public void saveResult(String comp,ArrayList lane1,ArrayList lane2,ArrayList lane3,
            ArrayList lane4,ArrayList lane5) {
        try {

            Document doc = new Document().
                    append("comp", comp).
                    append("Lane1",lane1 ).
                    append("Lane2",lane2).
                    append("Lane3", lane3).
                    append("Lane4", lane4).
                    append("Lane5", lane5);

            coll.insertOne(doc);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    public void save(Object obj){
        coll.insertOne(obj);
    }
    public FindIterable<Document> getResults(){
        return coll.find();
    }
}
