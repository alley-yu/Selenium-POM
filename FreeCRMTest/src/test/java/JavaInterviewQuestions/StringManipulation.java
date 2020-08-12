package JavaInterviewQuestions;

import java.util.Arrays;

public class StringManipulation {

	public static void main(String[] args) {
		
		String str = "Today is the first day of this school year.";
		
		System.out.println("Length: " + str.length());
		
		System.out.println("First a is the " + (str.indexOf("a")+1) + "th character.");
		
		System.out.println("Second a is the " + (str.indexOf("a", str.indexOf("a")+1)+1) + "th character.");
		
		System.out.println("is starts at " + (str.indexOf("is")+1) + "th character.");
		
		System.out.println("Return " + str.indexOf("abcd") + " means no such string found.");
		
		System.out.println(str.substring(40));
		
		System.out.println(str.substring(2, 8));
		
		System.out.println(str.replaceAll(" ", "_"));
		
		String wordArr[] = str.split(" ");
		for(String word: wordArr) {
			System.out.println(word);
		}
		
	}

}
