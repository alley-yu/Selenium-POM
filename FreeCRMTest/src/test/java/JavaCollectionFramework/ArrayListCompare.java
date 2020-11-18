package JavaCollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListCompare {

	public static void main(String[] args) {
		
		ArrayList<String> l1 = new ArrayList<String>(Arrays.asList("B", "A", "E", "C", "D"));
		ArrayList<String> l2 = new ArrayList<String>(Arrays.asList("B", "A", "F", "C", "D"));
		ArrayList<String> l3 = new ArrayList<String>(Arrays.asList("B", "A", "E", "C", "D"));
		
		//1. Use sort method to sort ArrayLists, then use equals method to compare
		
		Collections.sort(l1);
		Collections.sort(l2);
		Collections.sort(l3);
		
		System.out.println("l1 and l2 are same lists: " + l1.equals(l2));
		System.out.println("l1 and l3 are same lists: " + l1.equals(l3));
		
		//2. Compare 2 lists, remove the common elements from one list to get the remaining
		l3.removeAll(l2);
		System.out.println(l3);
		
		//3. Get the common elements
		l2.retainAll(l1);
		System.out.println(l2);
	}

}
