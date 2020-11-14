package JavaCollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListIteration {

	public static void main(String[] args) {
		
		//Virtual Capacity for ArrayList is 10 as default. Specify if needed.
		ArrayList<String> studentList = new ArrayList<String>();
		studentList.add("Jun");
		studentList.add("Alley");
		studentList.add("Yufei");
		studentList.add("Owen");
		
		//for loop
		System.out.println("------ for loop ------");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i));
		}
		
		//for each loop
		System.out.println("------ for each loop ------");
		for (String student: studentList) {
			System.out.println(student);
		}
		
		//JDK 8: stream with lambda
		System.out.println("------ stream with lambda ------");
		studentList.stream().forEach(student -> System.out.println(student));
		
		//Use Iterator
		System.out.println("------ use Iterator ------");
		Iterator<String> it = studentList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
