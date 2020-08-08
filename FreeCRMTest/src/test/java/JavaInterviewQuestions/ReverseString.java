package JavaInterviewQuestions;

public class ReverseString {

	public static void main(String[] args) {
		
		//There is no reverse method for String class, but it can be used in StringBuffer class.
		//String is a inmutable class, StringBuffer is a mutable class.
		
		String s = "Selenium";
		String rev = "";
		int len = s.length();
		
		for(int i = len - 1; i >= 0; i--) {
			rev = rev + s.charAt(i);
		}
		
		System.out.println("Use For Loop to reverse a string: " + rev);
		
		StringBuffer sb = new StringBuffer(s);
		System.out.println("Use StringBuffer class to reverse a string: " + sb.reverse());

	}

}
//s[7]
//