package JavaCollectionFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class HashMapBasics {

	public static void main(String[] args) {
		
		HashMap<String, String> countryCapital = new HashMap<String, String>();
		countryCapital.put("US", "Washington DC");
		countryCapital.put("UK", "London");
		countryCapital.put("Canada", "Ottawa");
		countryCapital.put("China", "Shanghai");
		countryCapital.put("Russia", "Moscow");
		countryCapital.put(null, "Nowhere"); //One null key allowed
		countryCapital.put("China", "Beijing"); //Duplicate key, value will be overridden
		countryCapital.put("Mexico", null);
		
		//Iterator: iterate the key by using keySet()
		System.out.println("------- Iterator: iterate the key by using keySet() ---------");
		Iterator<String> itKey = countryCapital.keySet().iterator();
		while (itKey.hasNext()) {
			String key = itKey.next();
			System.out.println("Country: " + key + " Capital: " + countryCapital.get(key));
		}
		System.out.println();
		
		//Traverse keys by using keySet()
		System.out.println("------- Traverse keys by using keySet() ---------");
		for(String key: countryCapital.keySet()) {
			System.out.println("Country: " + key + " Capital: " + countryCapital.get(key));
		}
		System.out.println();
		
		//Interator: iterate over the key+value set by using entrySet()
		System.out.println("------- Interator: iterate over the key+value set by using entrySet() ---------");
		Iterator<Entry<String, String>> itSet = countryCapital.entrySet().iterator();
		while (itSet.hasNext()) {
			Entry<String, String> entrySet = itSet.next();
			System.out.println("Country: " + entrySet.getKey() + " Capital: " + entrySet.getValue());
		}
		System.out.println();
		
		
		//Traverse country + capital set by using for...each...entryset()
		System.out.println("------- Traverse country + capital set by using for...each...entryset() ---------");
		for(Entry<String, String> entrySet: countryCapital.entrySet()) {
			System.out.println("Country: " + entrySet.getKey() + " Capital: " + entrySet.getValue());
		}
		System.out.println();
		
		//Iterate hashmap by using JDK 8 and Lambda forEach()
		System.out.println("------- Iterate hashmap by using JDK 8 and Lambda forEach() -------");
		countryCapital.forEach((country, capital)->System.out.println("Country: " + country + " Capital: " + capital));
		
		
	}

}
