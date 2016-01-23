package model;

import java.util.ArrayList;
import twitter4j.TwitterException;

public class TwitterQ {
	public static void main(String[] args) throws TwitterException {

		ArrayList<MapData> mdlist = new ArrayList<MapData>();

		MapData.collectData(mdlist);

		for (MapData m : mdlist) {
			System.out.println("Lat: " + m.getLat() + ", Long: " + m.getLong());
		}
		
		

	}
}