package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class MapData {
	private double longitude;
	private double latitude;

	public MapData(double lo, double la) {
		this.longitude = lo;
		this.latitude = la;
	}

	public double getLong() {
		return longitude;
	}

	public double getLat() {
		return latitude;
	}

	public static void collectData(ArrayList<MapData> mdlist, String q) {
		TwitterFactory tf = new TwitterFactory(Config.getOAuth().build());
		Twitter twitter = tf.getInstance();

		Query query = new Query(q);
		query.setCount(5);

		try {

			QueryResult result;
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();

				for (Status tweet : tweets) {
					if (tweet.getGeoLocation() != null) {
						System.out.println("Data Added!");
						MapData md = new MapData(tweet.getGeoLocation().getLatitude(),
								tweet.getGeoLocation().getLongitude());
						mdlist.add(md);
					}
				}
			} while ((query = result.nextQuery()) != null);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}
		exData(mdlist);
	}
	
	public String coordToString(double lat, double lng){
		
		
		
		return null;
		
	}

	public static void exData(ArrayList<MapData> mdlist) {
		
		Random rng = new Random();
		int exp = 50;
		int size = mdlist.size();
		for(int i=0; i<size; i++){
			for(int j=0; j<exp; j++){
				double rndlong = (rng.nextDouble()*4 - 2) + mdlist.get(i).getLong();
				double rndlat = (rng.nextDouble()*4 - 2) + mdlist.get(i).getLat();
				MapData m = new MapData(rndlong, rndlat);
				mdlist.add(m);
				
			}
		}
		
	}
}