/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;

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
        }
    }

    public void saveResult(int lane,String name,float time,int place) {
        try {

            BasicDBObject doc = new BasicDBObject("Lane",lane ).
                    append("Name",name ).
                    append("Time", time).
                    append("Place", place);

            coll.insertOne(doc);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    public void save(Object obj){
        coll.insertOne(obj);
    }
}
