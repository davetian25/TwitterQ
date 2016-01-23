package model;

import java.util.ArrayList;
import java.util.List;

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

	public static void collectData(ArrayList<MapData> mdlist) {
		TwitterFactory tf = new TwitterFactory(Config.getOAuth().build());
		Twitter twitter = tf.getInstance();

		Query query = new Query("#blizzard2016");
		query.setCount(3);

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
						// System.out.println("Latitude:" +
						// tweet.getGeoLocation().getLatitude() + ", Longitude:
						// " + tweet.getGeoLocation().getLongitude());
					}
				}
			} while ((query = result.nextQuery()) != null);
			// System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}
	}
}