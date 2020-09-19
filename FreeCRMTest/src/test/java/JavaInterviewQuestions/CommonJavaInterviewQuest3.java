package JavaInterviewQuestions;

public class CommonJavaInterviewQuest3 {
	
	public static boolean isPrime(int num) {
		for (int i = 2; i <= num/2; i++) {
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void primesAddTogether(int num) {
		boolean flag = false;
		for (int i = 2; i <= num/2; i++) {
			if(isPrime(i) && isPrime(num - i)) {
				flag = true;
				System.out.println(num + " can be expressed by adding two prime numbers, " + i + " and " + (num-i));
			}
		}
		if (!flag) {
			System.out.println(num + " cannot be expressed by adding two prime numbers.");
		}
	}
	
	public static int addNumWithRecursion(int num){
		
		if(num != 0) {
			return num + addNumWithRecursion(num - 1);
		}else{
			return num;
		}
	}
	
	public static int factorialWithRecursion(int num) {
		if(num >= 1) {
			return num * factorialWithRecursion(num - 1);
		}else {
			return 1;
		}
	}
	
	public static void GCDWithoutRecursion(int num1, int num2) {
		
		int smallerNum;
		if (num1 <= num2) {
			smallerNum = num1;
		}
		smallerNum = num2;
		
		for (int i = 0; i < smallerNum; i++) {
			if (num1%(smallerNum - i) == 0 && num2%(smallerNum - i) == 0) {
				System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + (smallerNum - i));
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		primesAddTogether(34);
		
		System.out.println("Sum of Natural Numbers: " + addNumWithRecursion(100));
		
		System.out.println("Factorial Number: " + factorialWithRecursion(10));
		
		GCDWithoutRecursion(18, 9);
		

	}

}
