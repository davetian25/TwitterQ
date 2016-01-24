package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TwitterQTests {

	@Test
	public void test() {
		ArrayList<MapData> mdlist = new ArrayList<MapData>();
		MapData md1 = new MapData(73.012823, 140.8294384);
		MapData md2 = new MapData(75.012823, 138.3894384);
		MapData md3 = new MapData(63.012823, 130.8294384);
		MapData md4 = new MapData(74.422343, 144.4958384);
		MapData md5 = new MapData(75.034323, 135.5332384);
		MapData md6 = new MapData(73.343423, 139.2343284);
		MapData md7 = new MapData(72.343423, 142.43223484);
		MapData md8 = new MapData(71.712823, 142.8294384);
		MapData md9 = new MapData(72.012823, 144.6294384);
		MapData md10 = new MapData(73.012823, 141.2354384);
		
		mdlist.add(md1);
		mdlist.add(md2);
		mdlist.add(md3);
		mdlist.add(md4);
		mdlist.add(md5);
		mdlist.add(md6);
		mdlist.add(md7);
		mdlist.add(md8);
		mdlist.add(md9);
		mdlist.add(md10);
		
		MapData.exData(mdlist);
		
		for(MapData m : mdlist){
			System.out.println(m.getLat());
		}
	}

}
