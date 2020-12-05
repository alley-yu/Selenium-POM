package JavaCollectionFramework;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapSync {

	public static void main(String[] args) {
		
		//1. Create Synchronized Map: use synchronizedMap() method in Collections class
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("A", "test1");
		map1.put("B", "test2");
		map1.put("C", "test3");
		
		Map<String, String> syncMap1 = Collections.synchronizedMap(map1);
		System.out.println(syncMap1.get("B"));
		
		//2. Create concurrentMap: it won't throw any ConcurrentModificationException error.
		ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<String, String>();
		concurrentMap.put("D", "test4");
		concurrentMap.put("E", "test5");
		concurrentMap.put("F", "test6");
		System.out.println(concurrentMap.get("D"));

	}

}
