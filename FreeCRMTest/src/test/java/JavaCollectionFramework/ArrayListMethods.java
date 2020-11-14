package JavaCollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListMethods {

	public static void main(String[] args) {
		
		ArrayList<String> ar1 = new ArrayList<String>();
		ar1.add("Java");
		ar1.add("Phthon");
		ar1.add("JavaScript");
		ar1.add("VB");
		
		ArrayList<String> ar2 = new ArrayList<String>();
		ar2.add("PHP");
		ar2.add("Ruby");
		
		//add ar2 at the end of ar1
//		ar1.addAll(ar2);
//		System.out.println(ar1);
		
		//add ar2 at the index = 2 of ar1, in the middle of ar1
//		ar1.addAll(2, ar2);
//		System.out.println(ar1);
		
		//The return of clone method is object. So need to tell what type I need, ArrayList
		ArrayList<String> ar1Clone = (ArrayList)ar1.clone();
		System.out.println(ar1Clone);
		
		//use asList to get help from other list. If element doesn't exist, return -1
		ArrayList<String> nameList = new ArrayList<String>(Arrays.asList("Jack", "Michael", "Patrick", "Mike", "Patrick", "Jack"));
		System.out.println(nameList.lastIndexOf("Patrick"));
		
		nameList.remove("Patrick");
		System.out.println(nameList);
		
		nameList.remove(0);
		System.out.println(nameList);
		
		//remove elements which follows the if condition
		ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		numList.removeIf(num -> num%2 == 0); //-> is Lambda arrow, remove all even numbers
		System.out.println(numList);
		
		//Use retainAll method
		ArrayList<String> nameList1 = new ArrayList<String>(Arrays.asList("Jack", "Michael", "Patrick", "Tom", "Mike", "Patrick", "Jack"));
		System.out.print("Initial Name List: ");
		System.out.println(nameList1);
		nameList1.retainAll(Collections.singleton("Patrick"));
		System.out.print("Retained Name List: ");
		System.out.println(nameList1);
		
		//Sub ArrayList: [fromIndex, toIndex)
		ArrayList<Integer> numList1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		ArrayList<Integer> subList = new ArrayList<Integer>(numList1.subList(2, 6));
		System.out.println(subList);
		
		//Convert ArrayList to array
		ArrayList<String> nameList2 = new ArrayList<String>(Arrays.asList("Jack", "Michael", "Patrick", "Tom", "Mike", "Patrick", "Jack"));
		Object nameArray[] = nameList2.toArray(); //the return will be object.
		System.out.println(Arrays.toString(nameArray));
		
		for (Object name: nameArray) {
			System.out.println((String)name);
		}
		
		
		
	}
	


}
