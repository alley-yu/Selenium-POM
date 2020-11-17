package JavaCollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedArrayList {

	public static void main(String[] args) {
		
		//1. Use Collections.synchronizedList() method to return synchrozed ArrayList
		
		List<String> nameList = Collections.synchronizedList(new ArrayList<String>());
		
		nameList.add("Jave");
		nameList.add("Python");
		nameList.add("Ruby");
		
		//For add or remove, no need explicit synchronization.
		
		//To fetch/traverse the values from the list, we have to use explicit synchronization.
		synchronized (nameList) {
			
			Iterator<String> it = nameList.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}
		
		
		//2. Use CopyOnWriteArrayList class to make Thread safe variant of ArrayList
		
		CopyOnWriteArrayList<String> empList = new CopyOnWriteArrayList<String>();
		
		empList.add("Michael");
		empList.add("Patrick");
		empList.add("Steve");
		
		//No need to have any explicit synchronization
		
		Iterator<String> it = empList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
