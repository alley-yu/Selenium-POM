package JavaInterviewQuestions;

import java.util.Arrays;

public class GreatestSmallestNumber {

	public static void main(String[] args) {
		 
		int numbers[] = {23, -15, 12, -25, 4567, 48};
		int greatestNum = numbers[0];
		int smallestNum = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			if(greatestNum < numbers[i]) {
				greatestNum = numbers[i];
			}else if(smallestNum > numbers[i]) {
				smallestNum = numbers[i];
			}
		}
		
		System.out.println("The original array is: " + Arrays.toString(numbers));
		System.out.println("The greatest number is: " + greatestNum);
		System.out.println("The smallest number is: " + smallestNum);

	}

}
