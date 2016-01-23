package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class exDataTest {

	@Test
	public void exDataTest(){
		
		ArrayList<MapData> mdlist = new ArrayList<MapData>();
		int rangeMin = -2;
		int rangeMax = 2;
		
		Random r = new Random();
		double randomValue1 = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		double randomValue2 = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

		
		for(int i = 0; i < 15; i++){
			MapData t = new MapData(100.00 + randomValue1, 100.00 + randomValue2);
			mdlist.add(t);
			

			randomValue1 = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			randomValue2 = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			
			
		}
		assertEquals(100.00, mdlist.get(0).getLat(), 2.00000000001);
		assertEquals(100.00, mdlist.get(3).getLat(), 2.00000000001);
		assertEquals(100.00, mdlist.get(7).getLat(), 2.00000000001);
		assertEquals(100.00, mdlist.get(14).getLat(), 2.00000000001);
		assertEquals(100.00, mdlist.get(10).getLat(), 2.00000000001);

		
	}

}
