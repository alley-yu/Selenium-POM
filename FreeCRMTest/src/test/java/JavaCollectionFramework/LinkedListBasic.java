package JavaCollectionFramework;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListBasic {
	
	//1. Linked List is a default calss in Java. It can be used as List, Stack and Queue.
	//2. It allows null entry, can contain duplicate elements.
	//3. It is not synchronized (not thread safe).
	//4. It is dynamic collection, so the insertion and deletion can be easily implemented.
	//5. In Linked List, the manipulation is fase because we don't need any shifting.

	//Linked List Constructors:
	//LinkedList();
	//LinkedList(Collection c);

	public static void main(String[] args) {
		
		LinkedList<String> names = new LinkedList<String>();
		names.add("Alley");
		names.add("Jon");
		names.add("Yufei");
		names.add("Owen");
		
		System.out.println(names.size());
		System.out.println(names.get(2));
		
		names.add(0, null);
		System.out.println(names.size());
		System.out.println(names.getFirst());
		System.out.println(names.getLast());
		
		System.out.println("---- Use Iterator ---");
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("---- For Each Loop ---");
		for (String name: names) {
			System.out.println(name);
		}
		
		names.remove(0);
		Collections.sort(names);
		System.out.println(names);
		
		
	}

}
