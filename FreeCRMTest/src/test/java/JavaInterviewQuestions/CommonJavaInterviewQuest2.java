package JavaInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class CommonJavaInterviewQuest2 {
	
	public static void alphabetCheck() {
		
		char c = 'z';
		if ((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')) {
			System.out.println(c + " is an alphabet character.");
		}else {
			System.out.println(c + " is not an alphabet character.");
		}
		
		//actually, comparing character is comparing its ascii code.
		int ascii = c;
		System.out.println(ascii);
	}
	
	//In Fibonacci Series, find out the numbers no greater than N
	public static void fibonacciSeries(int toNum) {
		List<Integer> fibonacciSeries = new ArrayList<Integer>();
		fibonacciSeries.add(0);
		fibonacciSeries.add(1);
		
		while (fibonacciSeries.get(fibonacciSeries.size()-1) + fibonacciSeries.get(fibonacciSeries.size()-2) <= toNum) {
			
				fibonacciSeries.add(fibonacciSeries.get(fibonacciSeries.size()-1) + fibonacciSeries.get(fibonacciSeries.size()-2));
		}
		
		System.out.println(fibonacciSeries);
		
	}
	
	//find out first N number in Fibonacci Series
	public static void fibonacciSeries1(int uptoNth) {
		int f1 = 0;
		int f2 = 1;
		
		for (int i = 1; i <= uptoNth; i++) {
			System.out.print(f1 + " ");
			int next = f1 + f2;
			f1 = f2;
			f2 = next;
		}
		
		System.out.println();
		
	}
	
	//print out all characters, actually it's based on its ascii code. There will be 6 chars between Z and a.
	public static void printChars() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c + " ");
		}
		
		System.out.println();
	}
	
	//find out the number of digits of an integer
	public static void numOfDigits(int numToCheck) {
		int digit = 0;
		int num = numToCheck;
		
		while (num != 0) {
			num = num/10;
			digit++;
			
		}
		
		System.out.println(numToCheck + " is a " + digit + " digits number.");
	}
	
	public static void reverseNum(int num) {
		int numReversed = 0;
		while(num != 0) {
			numReversed =  numReversed * 10 + num % 10;
			num = num/10;
		}
		
		System.out.println(numReversed);
	}
	
	public static void powerOfNum(int num, int power) {
//		int num = 5;
		int result = 1;
		
		if(power != 0) {
			for (int i = 1; i <= power; i++) {
				result = result * num;
			}
		}
		
		
		System.out.println(num + "^" + power + " : " + result);
	}
	
	public static void checkPalindrome(int numInput) {
		int num = numInput;
		int rev = 0;
		while (num != 0) {
			rev = rev * 10 + num%10;
			num = num/10;
		}
		
		if(rev == numInput) {
			System.out.println(numInput + " is palindrome.");
		}
	}
	
	public static void checkPalindrome(String strInput) {
		boolean palindrome = true;
		int i = 0;
			
		while (i < (strInput.length())/2) {
			
			if (strInput.charAt(i) != strInput.charAt(strInput.length()-1 - i)) {
				palindrome = false;
				break;
			}
			i++;
		}
		
		System.out.println(strInput + " is palindrome: " + palindrome);
	}
	
	public static boolean checkPrime(int num) {
		boolean isPrime = true;
		int i = 2;
		while (num != 0 && i < num) {
				if(num%i == 0) {
					isPrime = false;
					break;
				}
				i++;
			}
		
//		System.out.println(num + " is a Prime Number: " + isPrime);
		return isPrime;
	}
	
	public static void findPrime(int numFrom, int numTo) {
		List<Integer> primeList = new ArrayList<Integer>();
		for (int i = numFrom; i <= numTo; i++) {
			if (checkPrime(i)) {
				primeList.add(i);
			}
		}
		System.out.println("The prime numbers between " + numFrom + " and " + numTo + " are: " + primeList);
	}
	
	public static boolean isArmstrongNum(int num) {
		
		int iniNum = num;
		int sum = 0;
		List<Integer> digitList = new ArrayList<Integer>();
		
		while(num != 0) {
			digitList.add(num%10);
			num = num /10;
		}
		
		for(int digit: digitList) {
			sum = sum + (int)Math.pow(digit, digitList.size());
		}
		
//		if (sum == iniNum) {
//			isArmstrong = true;
//		}
		
//		System.out.println(iniNum + " is an armstrong number: " + (sum == iniNum));
		
		return sum == iniNum;
		
	}
	
	public static void findArmstrongNum(int numFrom, int numTo) {
		
		System.out.println("All armstrong numbers between " + numFrom + " and " + numTo + " are: ");
		
		for (int i = numFrom; i <= numTo; i++) {
			if (isArmstrongNum(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
	

	public static void main(String[] args) {
		
//		alphabetCheck();
		
		fibonacciSeries(30);
		
		fibonacciSeries1(10);
		
		printChars();
		
		numOfDigits(70);
		
		reverseNum(345);
		
		powerOfNum(3, 0);
		
		checkPalindrome(12321);
		
		checkPalindrome("12345654321");
		
		checkPrime(32);
		
		findPrime(10, 20);
		
		isArmstrongNum(1634);
		
		findArmstrongNum(100, 10000);
		
	

	}

}
