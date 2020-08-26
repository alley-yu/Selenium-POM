package JavaInterviewQuestions;

public class FactorialNumber {
	
	//1. Without recursive - use for loop
	public static int factorial(int num) {
		
		int fact = 1;
		
		if (num == 0)
			return fact;

		
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		
		return fact;
	}
	
	//2. With recursive 
	public static int recursiveFactorial(int num) {
		
		if (num == 1 || num == 0)
			return 1;
		else
			return(num * recursiveFactorial(num - 1));
	}

	public static void main(String[] args) {
		
		int num = 5;
		
		System.out.println("Factorial Number of " + num + " is: " + factorial(num));
		
		System.out.println("Factorial Number of " + num + " is: " + recursiveFactorial(num));
		

	}

}
