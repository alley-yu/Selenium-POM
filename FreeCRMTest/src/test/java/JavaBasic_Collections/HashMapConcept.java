package JavaBasic_Collections;

import java.util.HashMap;
import java.util.Map.Entry;


public class HashMapConcept {

	public static void main(String[] args) {
		
		//HashMap is a class implementing Map interface, extends AbstractMap
		//It contains only unique elements
		//It stores value like "Key, Value" set
		//It may contain on null key and multiple null values
		//It maintains no order
		//It is not synchronized - not thread safe, no locking, so its performace is better than HashTable, which is synchronized.
		//Example: when 2 reference refers to 1 hashmap, the hashmap won't be locked.
		//         So if 1 ref(thread) changed the value, the other ref will get the updated value.
		//         But instead it should get the original value.
	
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "Selenium");
		hm.put(2, "QTP");
		hm.put(3, "Test Complete");
		hm.put(4, "RTP");
		
		System.out.println(hm.get(1));
		
		//Use for each loop to get each element of hashmap hm, key + value sets
		for(Entry<Integer, String> m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		
		hm.remove(3);
		
		System.out.println(hm);
		
		//In hashmap, value can be a class
		HashMap<Integer, Employees> emp = new HashMap<Integer, Employees>();
		
		Employees e1 = new Employees("Jon", 41, "Admin");
		Employees e2 = new Employees("Yufei", 12, "Dev");
		Employees e3 = new Employees("Owen", 6, "QA");
		
		emp.put(1, e1);
		emp.put(2, e2);
		emp.put(3, e3);
		
		for(Entry<Integer, Employees> employee : emp.entrySet()) {
			int key = employee.getKey();
			Employees e = employee.getValue();
			
			System.out.print("employee " + key + " info: ");
			System.out.println(e.name + " " + e.age + " " + e.depart);
		}

	}

}
