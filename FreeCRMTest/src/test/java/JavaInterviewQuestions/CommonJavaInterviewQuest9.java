package JavaInterviewQuestions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CommonJavaInterviewQuest9 {
	
	public static void roundingNum(double number, int places) {
		
		double scale = Math.pow(10, places);
		double result = Math.round(number * scale)/scale;
		
		
		System.out.println(result);
	}


	public static void main(String[] args) throws ParseException {
		
		//remove space in string
		String str = "We are making Jazz Music and Beautiful Bossa Nova Music for relaxation";
		System.out.println(str.replace(" ", ""));
		
		//Convert String to Date
		String strDate = "06/21/1979";
		Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(strDate);
		System.out.println(date1);
		
		//round to n decimal places
		roundingNum(3.1415927, 5);
		
		//Concatenate two arrays by using System.arraycopy
		//System.arraycopy(src, srcPos, dest, destPos, length);
		String[] arr1 = {"bag", "cake", "cat", "apple", "applesauce"};
		String[] arr2 = {"bread", "bike", "scooter"};
		String[] result = new String[arr1.length + arr2.length];
		
		System.arraycopy(arr1, 0, result, 0, arr1.length);
		System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
		
		System.out.println("The resault of concatenating arr1 and arr2 is: ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
		System.out.println();
		System.out.println(Arrays.toString(result));
		
		//Convert char to String
		char c = 'a';
		System.out.println(String.valueOf(c));

		//Convert String to char
		String str1 = "a";
		System.out.println(str1.charAt(0));
		
		//Join two lists
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
		list1.add("bed");
		list1.add("pigeon");
		list1.add("lighthouse");
		list1.add("cupcake");
		
		list2.add("coach");
		list2.add("homework");
		list2.add("spaceship");
		list2.add("house");
		list2.add("cushion");
		
		List<String> result1 = new ArrayList<String>();
		result1.addAll(list1);
		result1.addAll(list1.size()-1, list2);
		
		System.out.println(result1);

	}

}
