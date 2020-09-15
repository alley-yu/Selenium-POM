package JavaInterviewQuestions;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Please enter two numbers:");
		
		double firstNum = reader.nextDouble();
		double secoundNum = reader.nextDouble();
		
		System.out.println("Please input operator (+, -, *, /):");
		
		char operator = reader.next().charAt(0);
		
		double result = 0;
		
		switch(operator) {
		case '+':
			result = firstNum + secoundNum;
			break;
		case '-':
			result = firstNum - secoundNum;
			break;
		case '*':
			result = firstNum * secoundNum;	
			break;
		case '/':
			result = firstNum / secoundNum;
			break;
			
		default:
			System.out.println("Please input correct operator:");
			break;
		}
		System.out.print(firstNum);
		System.out.print(operator);
		System.out.print(secoundNum);
		System.out.print("=" + result);

	}
}
