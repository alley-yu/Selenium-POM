package JavaInterviewQuestions;

import java.util.Scanner;

public class CommonJavaInterviewQuest1 {
	
	public static void printInteger() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please input an integer: ");
		
		int num = reader.nextInt();
		System.out.println("Your input is: " + num);
	}
	
	public static void floatMultiply() {
		
		float f1 = 2.5f;
		float f2 = 4.3f;
		
		System.out.println("The product of " + f1 + " and " + f2 + " is " + (f1 * f2));
	}
	
	public static void convertAsciiChar() {
		
		char c = 'A';
		int ascii1 = c;
		int ascii2 = (int)c;
		
		System.out.println("The ASCII value of " + c + " is: " + ascii1);
		System.out.println("The ASCII value of " + c + " is: " + ascii2);
	}
	
	public static void vowelOrConsonant() {
		
		char ch = 'a';
		
		switch(ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			System.out.println(ch + " is a vowel.");
			break;
			
		default:
			System.out.println(ch + " is a consonant.");
			break;
		}
	}
	
	public static void greatestNum() {
		int numList[] = {5, 25,7};
		int greatestNum = numList[0];
		
		for (int i = 1; i < numList.length; i++) {
			if (greatestNum < numList[i]) {
				greatestNum = numList[i];
			}
		}
		
		System.out.println("The greatest number is " + greatestNum);
		
	}
	
	public static void leapYear() {
//		Every year that is exactly divisible by four is a leap year, except for years that are exactly divisible by 100, 
//		but these centurial years are leap years if they are exactly divisible by 400. 
//		For example, the years 1700, 1800, and 1900 are not leap years, but the years 1600 and 2000 are.

		int year = 2016;
		boolean leap = false;

		if (year%400 == 0) {
			leap = true;
		}else if (year%100 != 0 && year%4 ==0) {
			leap = true;
		}
		
		System.out.println("The year " + year + " is leap year: " + leap);
	}

	public static void main(String[] args) {
		
//		printInteger();
		
//		floatMultiply();
		
//		convertAsciiChar();
		
//		vowelOrConsonant();
		
//		greatestNum();
		
		leapYear();

	}

}
