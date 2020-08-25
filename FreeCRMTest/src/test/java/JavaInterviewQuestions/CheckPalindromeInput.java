package JavaInterviewQuestions;

public class CheckPalindromeInput {
	
	public static boolean isPalindrome(String inputToCheck) {
		for(int i = 0; i < inputToCheck.length()/2; i++) {
			if(inputToCheck.charAt(i) != inputToCheck.charAt(inputToCheck.length()-1-i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void isPalindromeNum(int num) {
		
		int r = 0;
		int sum = 0;
		int t = num;
		
		while (t>0) {
			r = t%10;
			sum = sum*10 + r;
			t = t/10;
		}
		
		if (sum == num) {
			System.out.println(num + " is Palindrome number. ");
		}else {
			System.out.println(num + " is not Palindrome number. ");
		}
	}

	public static void main(String[] args) {
		
		String inputToCheck = "abcdefgfedcba";
		System.out.println("Your input " + inputToCheck + " is palindrome: " + isPalindrome(inputToCheck));

		isPalindromeNum(454);
	}

}
