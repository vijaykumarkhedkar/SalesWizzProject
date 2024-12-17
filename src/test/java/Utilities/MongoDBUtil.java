package Utilities;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

public class MongoDBUtil {

	public static String getOtpFromDb() {
		String otp = "";

		// MongoDB connection setup
		String connectionString = "mongodb://root:Vv8isd3NyhYH@192.168.1.203:27017/sales-wizz-test-user";

		// Establish MongoDB connection
		try (MongoClient mongoClient = MongoClients.create(connectionString)) {
			MongoDatabase database = mongoClient.getDatabase("sales-wizz-test-user");
			MongoCollection<Document> collection = database.getCollection("otp");

			String mobileNumber = "5123456789";
			
			 // Aggregate to get the latest OTP document
	        AggregateIterable<Document> iterable = collection.aggregate(
	                Arrays.asList(
	                        Aggregates.match(Filters.eq("mobileNumber", mobileNumber)),
	                        Aggregates.sort(Sorts.descending("createdDate")),
	                        Aggregates.limit(1)
	                )
	        );

	        // Get the first document from the aggregation result
	        Document otpDocument = iterable.first();
			

			if (otpDocument != null) {
				otp = otpDocument.getString("otpNumber");
				System.out.println("Latest OTP for mobile number " + ": " + otp);
			} else {
				System.out.println("No OTP found for mobile number " + mobileNumber);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return otp;
	}

}
