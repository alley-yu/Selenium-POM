package JavaCollectionFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class IterateHashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> testMap = new HashMap<String, Integer>();
		testMap.put("A", 100);
		testMap.put("B", 200);
		testMap.put("C", 300);
		testMap.put("D", 400);
		
		
		Iterator<String> keyIt = testMap.keySet().iterator();
		while (keyIt.hasNext()) {
			String key = keyIt.next();
			System.out.println(testMap.get(key));
		}
		
		Iterator<Entry<String, Integer>> entryIt = testMap.entrySet().iterator();
		while (entryIt.hasNext()) {
			Entry<String, Integer> mapEntry = entryIt.next();
			System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
		}
		
		for (String key: testMap.keySet()) {
			System.out.println(testMap.get(key));
		}
		
		for (Entry<String, Integer> mapEntry: testMap.entrySet() ) {
			System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
		}

	}

}
