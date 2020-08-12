package JavaInterviewQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CheckDuplicateElements {

	public static void main(String[] args) {
		
		String codingLangs[] = {"Java", "JavaScript", "C++", "Python", "Java", "Ruby", "JavaScript"};
		
		//1. Use for loop to compare string one by one
		System.out.println("**** 1. For Loop ***********");
		for(int i = 0; i < codingLangs.length; i++) {
			for(int j = i + 1; j < codingLangs.length; j++) {
				if(codingLangs[i].equalsIgnoreCase(codingLangs[j])){
					System.out.println("Duplicated Element is found: " + codingLangs[i]);
				}
			}
		}
		
		System.out.println("***** 2. HashSet **********");
		
		//2. Use HashSet, which stores unique value
		//Set is an interface, HashSet is one of its class
		Set<String> langSet = new HashSet<String>();
		for(String lang: codingLangs) {
			if(langSet.add(lang) == false) {     //When there is duplicate value, adding will be failed, the return will be false.
				System.out.println("Duplicated Element is found: " + lang);
			}
		}
		
		System.out.println("***** 3. HashMap - check duplicate key **********");
		
		//3. Use HashMap - Check if having duplicate key, which stores the string
		Map<String, Integer> langMap1 = new HashMap<String, Integer>();
		for(int i = 0; i < codingLangs.length; i++) {
			if(!langMap1.containsKey(codingLangs[i])) {
				langMap1.put(codingLangs[i], 1);
			}else {
				System.out.println("Duplicated Element is found: " + codingLangs[i]);
			}
		}
		
		System.out.println("***** 4. HashMap - using count as value **********");
		
		//4. Use HashMap
		Map<String, Integer> langMap2 = new HashMap<String, Integer>();
		for(String lang: codingLangs) {
			Integer count = langMap2.get(lang);
			if(count == null) {
				langMap2.put(lang, 1);
			}else {
				langMap2.put(lang, ++count);
			}
		}
		//Iterate HashMap
		Set<Entry<String, Integer>> entrySet = langMap2.entrySet();
		for(Entry<String, Integer> entry: entrySet) {
			if(entry.getValue() > 1) {
				System.out.println("Duplicated Element is found: " + entry.getKey());
			}
		}
		

	}

}
