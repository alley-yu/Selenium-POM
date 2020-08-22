package JavaInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPrimeNumber {
	
	public static boolean isPrimeNum(int num) {
		
		if (num <= 1) {
			return false;
		}
		
		for (int i = 2; i < num; i++) {
			if (num%i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static Map<String, Object> isPrimeAndFactors(int num) {
		
		Map<String, Object> primeNumMap = new HashMap<String, Object>();
		
		List<Integer> factorsList = new ArrayList<Integer>();
		
		if (num <= 1) {
			primeNumMap.put("isPrime", false);
			return primeNumMap;
		}
		
		for (int i = 2; i < num; i++) {
			if (num%i == 0) {
				factorsList.add(i);
			}
		}
		
		if (!factorsList.isEmpty()) {
			factorsList.add(0, 1);
			factorsList.add(num);
			primeNumMap.put("isPrime", false);
			primeNumMap.put("factors", factorsList);
			
			return primeNumMap;
			
		}
		
		primeNumMap.put("isPrime", true);
		
		return primeNumMap;
		
	}
	
	public static void findPrimeNums(int toNum) {
		if (toNum < 2) {
			System.out.println("There won't be any prime number found upto " + toNum 
					+ ". Please try again.");
			return;
		}
		
		System.out.println("Upto " + toNum + ", all prime numbers are: ");
		for (int i = 2; i <= toNum; i++) {
			if (isPrimeNum(i)) {
				System.out.print(i + " ");
			}
		}
		
		
	}

	public static void main(String[] args) {
		
		int numToCheck = 576;
		System.out.println("Number " + numToCheck + " is a Prime Number: " + isPrimeNum(numToCheck));
		
		Boolean isPrimeNum = (Boolean) isPrimeAndFactors(numToCheck).getOrDefault("isPrime", false); //if no return from the method, set a default value "isPrime = false". This way can hancle null return.
		System.out.println("Number " + numToCheck + " is a Prime Number: " + isPrimeNum);
		Object factorsObj = isPrimeAndFactors(numToCheck).getOrDefault("factors", Collections.emptyList()); //if no return from the method, set a default empty list.
		if (!isPrimeNum) {
			System.out.println("All factors of number " + numToCheck + " are: " + factorsObj);
		}
		
		findPrimeNums(10);
		
	}

}
