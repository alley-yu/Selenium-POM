package JavaCollectionFramework;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapConcept {

	public static void main(String[] args) {
		
		TreeMap<Integer, String> salaryName = new TreeMap<Integer, String>();
		salaryName.put(1000, "Tom");
		salaryName.put(800, "Jack");
		salaryName.put(3000, "Patrick");
		salaryName.put(11000, "Steve");
		salaryName.put(21000, "Mike");
		
		System.out.println(salaryName); //Print out sorting by keys
		salaryName.forEach((k, v) -> System.out.println("Key = " + k + ",  Value = " + v));
		System.out.println("Least Salary: " + salaryName.firstKey());
		System.out.println("Most Salary: " + salaryName.lastKey());
		
		//Get the salary and name pair whose salary less than 3000: headMap()
		System.out.println(salaryName.headMap(3000));
		Set<Integer> salaryLess3000 = salaryName.headMap(3000).keySet();
		System.out.println(salaryLess3000);
		
		//Get the salary and name pair whose salary no less than 3000 (>=): tailMap()
		System.out.println(salaryName.tailMap(3000));
		Set<Integer> salaryMore3000 = salaryName.tailMap(3000).keySet();
		System.out.println(salaryMore3000);
		
		System.out.println("---------------");
		
		TreeMap<String, Integer> userName = new TreeMap<String, Integer>();
		userName.put("James", 100);
		userName.put("Brad", 200);
		userName.put("Albert", 400);
		userName.put("George", 50);
		userName.put("Larry", 900);
		userName.put("Ted", 120);
		userName.put("Paul", 300);
		

	}

}
