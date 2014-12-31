package test;

import java.net.UnknownHostException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class Test {

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {
		// add();
		// del();
		// upd();
		// sel();
	}

	public static void add() throws UnknownHostException {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("Mydb");
		DBCollection dbCollection = db.getCollection("MyCollection");
		BasicDBObject obj = new BasicDBObject();
		obj.put("type", 1234);
		obj.put("value", "fdfdffd");
		dbCollection.insert(obj);

	}

	public static void del() throws UnknownHostException {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("Mydb");
		DBCollection dbCollection = db.getCollection("MyCollection");
		BasicDBObject delDbo = new BasicDBObject();
		delDbo.put("type", 123);
		dbCollection.remove(delDbo);
	}

	public static void upd() throws UnknownHostException {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("Mydb");
		DBCollection dbCollection = db.getCollection("MyCollection");
		DBObject obj = new BasicDBObject();
		obj.put("type", 123456789);
		DBObject obj2 = dbCollection.findOne(obj);
		obj2.put("type", 12345);
		dbCollection.update(obj, obj2);
	}

	public static void sel() throws UnknownHostException {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("Mydb");
		DBCollection dbCollection = db.getCollection("MyCollection");
		DBCursor cur = dbCollection.find();
		while (cur.hasNext()) {
			System.out.println(cur.next());
		}

	}

}
