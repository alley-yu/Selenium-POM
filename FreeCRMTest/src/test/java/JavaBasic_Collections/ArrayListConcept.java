package JavaBasic_Collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListConcept {

	public static void main(String[] args) {
		
		Employees e1 = new Employees("Jon", 41, "Admin");
		Employees e2 = new Employees("Yufei", 12, "Dev");
		Employees e3 = new Employees("Owen", 6, "QA");
		
		//Create ArrayList for these employees objects (User defined class arraylist)
		ArrayList<Employees> empObj = new ArrayList<Employees>();
		empObj.add(e1);
		empObj.add(e2);
		empObj.add(e3);
		
		//Create iterator to traverse each employee object in ArrayList
		Iterator<Employees> it = empObj.iterator();
		while(it.hasNext()){
			Employees emp = it.next();
			System.out.println(emp.name + " " + emp.age + " " + emp.depart);
		}
		

	}

}
