package JavaInterviewQuestions;

public class ReverseInteger {

	public static void main(String[] args) {
		
		int num = 12345;
		int rev = 0;
		System.out.println("The Original Number is " + num);
//		System.out.println("num/10: " + num/10); //1234
//		System.out.println("num%10: " + num%10); //5
		
		while(num!=0) {
			rev = rev*10 + num%10;
			num = num/10;
		}
		
		System.out.println("The Reversed Number is: " + rev);
		
		//Use StringBuffer, but the output will be a string, instead of integer
		int num1 = 23456;
		System.out.println(new StringBuffer(String.valueOf(num1)).reverse());
		
	}

}
