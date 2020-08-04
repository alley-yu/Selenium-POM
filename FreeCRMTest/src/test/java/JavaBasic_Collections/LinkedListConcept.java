package JavaBasic_Collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListConcept {
	
	//Singly LinkedList

	public static void main(String[] args) {
		
		LinkedList<String> lList = new LinkedList<String>();
		lList.add("Alley");
		lList.add("is");
		lList.add("using");
		lList.add("Selenium");
		
		System.out.println("The content of LinkedList lList is " + lList);
		
		lList.addFirst("Today");
		lList.addLast("tool");
		
		System.out.println("The content of LinkedList lList is " + lList);
		
		lList.add(5, "automation");
		
		System.out.println("The content of LinkedList lList is " + lList);
		
		lList.set(0, "Everyday");
		lList.set(3, "uses");
		lList.remove(2);
		
		System.out.println("The content of LinkedList lList is " + lList);
		
		//print each element of the linkedlist
		//for loop
		System.out.println("*****using for loop");
		for(int i = 0; i < lList.size(); i++) {
			System.out.println(lList.get(i));
		}
		
		System.out.println("*****using for advanced loop - for each loop");
		for(String str : lList) {
			System.out.println(str);
		}
		
		System.out.println("*****using for interator");
		Iterator it = lList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("*****using for while loop");
		int num = 0;
		while(lList.size() > num) {
			System.out.println(lList.get(num));
			num++;
		}

	}

}
