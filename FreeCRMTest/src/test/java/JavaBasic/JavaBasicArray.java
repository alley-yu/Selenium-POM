package JavaBasic;

import java.util.ArrayList;

public class JavaBasicArray {

	public static void main(String[] args) {
		
//		Increment Test
		
		int a = 1;
		int b = a++; //post increment
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		int c = 1;
		int d = ++c; //pre increment
		System.out.println("c: " + c);
		System.out.println("d: " + d);
		
		
		int x = 1;
		int y = x++; 
		int z = ++x; 
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("z: " + z);
		
//		static array
		int arr[] = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		System.out.println(arr[2]);
		
		
		
//		Array: Static array has to store same data type data, use Object array to store different type data.
//		Object is a class.
		
		Object ob[] = new Object[3];
		ob[0] = 1;
		ob[1] = "Alley";
		ob[2] = 12.33;
		System.out.println(ob[1] + ": " + ob[2]);
		
//		ArrayList: a collection, dynamic array
//		ArrayList is a class.
		
		int n = 5;
		ArrayList<Integer> arrli = new ArrayList<Integer>(n);
		for (int i = 1; i <= n; i++) {
			arrli.add(i);
		}
		
		System.out.println(arrli);
		arrli.remove(3);
		System.out.println(arrli);
		
//		2D Array
		String arr1[][] = new String[2][3];
		System.out.println("arr1 has "+ arr1.length + " rows.");
		System.out.println("arr1 has "+ arr1[0].length + " columns.");
		
		arr1[0][0] = "A";
		arr1[0][1] = "B";
		arr1[0][2] = "C";
		
		arr1[1][0] = "A1";
		arr1[1][1] = "B1";
		arr1[1][2] = "C1";
		
		arr1[2][0] = "A2";
		arr1[2][1] = "B2";
		arr1[2][2] = "C2";

		

	}

}
