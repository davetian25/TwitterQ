package model;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterQ {
	public static void main(String[] args) throws TwitterException {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("rkmgVX3HTnQRLFBlGMxtA1KKH")
				.setOAuthConsumerSecret("ahSdYuN1CGCCus4QhnuNAVECKTYLMNWcpilM8Xo7AxXVV4VxOH")
				.setOAuthAccessToken("4801131805-4A1sWliUkfBb3rygz5TcfgX32FuENNi0NVfbr1J")
				.setOAuthAccessTokenSecret("V9g0cERTgiF7uzwaxqFRLTu18K6sV9us9ABpqDYsLdzDb");

		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		try {
			Query query = new Query("Obama");
			QueryResult result;
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
					System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
				}
			} while ((query = result.nextQuery()) != null);
			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}
	}
}
