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

	public static void main(String[] args) {
		
		String inputToCheck = "abcdefgfedcba";
		System.out.println("Your input " + inputToCheck + " is palindrome: " + isPalindrome(inputToCheck));

	}

}
