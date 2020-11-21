package JavaCollectionFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HashMapCompare {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(3, "C");
		
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(3, "C");
		map2.put(1, "A");
		map2.put(2, "B");
		
		HashMap<Integer, String> map3 = new HashMap<Integer, String>();
		map3.put(1, "A");
		map3.put(2, "B");
		map3.put(3, "C");
		map3.put(3, "D");
		
		//1. Compare two maps (with same key and value): equals()
		System.out.println("map1 same as map2: " + map1.equals(map2));
		System.out.println("map1 same as map3: " + map1.equals(map3));
		
		//2. Compare keys between maps: keySet()
		System.out.println("map1 and map2 have same keys: " + map1.keySet().equals(map2.keySet()));
		
		HashMap<Integer, String> map4 = new HashMap<Integer, String>();
		map4.put(1, "A");
		map4.put(2, "B");
		map4.put(3, "C");
		map4.put(4, "D");
		
		//3. Get the extra key when comparing two maps: HashSet (remove the common keys)
		HashSet<Integer> combinedKey = new HashSet<Integer>(map1.keySet());
		combinedKey.addAll(map4.keySet());
		combinedKey.removeAll(map1.keySet());
		System.out.println("the extra key when comparing map1 and map4 is: " + combinedKey);
		
		//4. Compare by values
		HashMap<Integer, String> map5 = new HashMap<Integer, String>();
		map5.put(1, "A");
		map5.put(2, "B");
		map5.put(3, "C");
		
		HashMap<Integer, String> map6 = new HashMap<Integer, String>();
		map6.put(4, "A");
		map6.put(5, "B");
		map6.put(6, "C");
		
		HashMap<Integer, String> map7 = new HashMap<Integer, String>();
		map7.put(1, "A");
		map7.put(2, "B");
		map7.put(3, "C");
		map7.put(4, "C");
		
		//duplicate is not allowed: ArrayList
		System.out.println("Same values from map5 and map6: " + new ArrayList<String>(map5.values()).equals(new ArrayList<String>(map6.values())));
		System.out.println("Same values from map5 and map7: " + new ArrayList<String>(map5.values()).equals(new ArrayList<String>(map7.values())));
		
		//duplicate is allowed
		System.out.println(new HashSet<String>(map5.values()).equals(new HashSet<String>(map7.values())));
		
	}

}
