package JavaBasic_Collections;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;

public class HashTableConcept {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Hashtable<Integer, String> h1 = new Hashtable<Integer, String>();
		h1.put(1, "Breakfast");
		h1.put(2, "Lunch");
		h1.put(3, "Dinner");
		
		//Create another hashtable h2 to clone h1
		Hashtable<Integer, String> h2 = new Hashtable<Integer, String>();
		h2 = (Hashtable<Integer, String>) h1.clone();
		
		System.out.println("Value of h1 " + h1);
		System.out.println("Value of h2 " + h2);
		
		h1.clear();
		
		System.out.println("Value of h1 " + h1);
		System.out.println("Value of h2 " + h2);
		
		if(h2.containsKey(2)) {
			System.out.println("The Key 2 is found.");
		}
		
		if(h2.containsValue("Dinner")) {
			System.out.println("We got dinner covered.");
		}
		
		h2.put(4, "Evening snack");
		
		//Use enumeration - element to print all values of the hashtable
		Enumeration<String> e = h2.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		//Use EntrySet to print all values of the hashtable
		for(Entry<Integer, String> en : h2.entrySet()) {
			System.out.println(en.getValue());
		}
		
		//re-populate h1 and check if it's same as h2
		h1.put(1, "Breakfast");
		h1.put(2, "Lunch");
		h1.put(3, "Dinner");
		h1.put(4, "Evening snack");
		
		if(h1.equals(h2)) {
			System.out.println("Two hashtables h1 and h2 are same.");
		}
		
		//Print out h1 and h2's hashcode, both should be same since h2 is the clone of h1.
		System.out.println(h1.hashCode());
		System.out.println(h2.hashCode());

	}

}
