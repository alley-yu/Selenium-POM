package JavaCollectionFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapToArrayList {

	public static void main(String[] args) {
		
		HashMap<String, Integer> compList = new HashMap<String, Integer>();
		compList.put("Apple", 10000);
		compList.put("Google", 20000);
		compList.put("Amazon", 30000);
		compList.put("Facebook", 40000);
		compList.put("Microsoft", 50000);
		
		//Iterate the HashMap
		Iterator<Entry<String, Integer>> it = compList.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> companyInfo = (Entry<String, Integer>) it.next();
			System.out.println(companyInfo.getKey() + ": " + companyInfo.getValue());
		}
		
		//Convert HashMap keys into ArrayList
		List<String> compNameList = new ArrayList<String>(compList.keySet());
		System.out.println(compNameList);
		for (String name: compNameList) {
			System.out.println(name);
		}
		
		//Convert HashMap values into ArrayList
		List<Integer> compSizeList = new ArrayList<Integer>(compList.values());
		System.out.println(compSizeList);
		for (Integer size: compSizeList) {
			System.out.println(size);
		}

	}

}
