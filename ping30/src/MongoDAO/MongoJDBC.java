package MongoDAO;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoJDBC {
	public static void initMongo() {
		try {
			  MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );  
			  MongoDatabase mongoDatabase = mongoClient.getDatabase("ping30");  
		       System.out.println("Connect to database successfully");
		}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		
	}
	
	public static void main(String args[]){
	
		try{
			 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		       
	         MongoDatabase mongoDatabase = mongoClient.getDatabase("ping30");  
	         
	         MongoCollection<Document> collection = mongoDatabase.getCollection("test");
	         
	         System.out.println(collection.count());
		}
		catch(Exception e){
			throw (e);
		}
	}
	
	
}
