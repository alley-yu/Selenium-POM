package JavaInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class CheckArmstrongNum {
	
	//ArmStrong Number: The number is equal to the sum of each digit to the power of the number's digit.
	//1634 = 1^4 + 6^4 + 3^4 + 4^4
	
	public static boolean isArmstrongNum(int num) {
		List<Integer> digits = new ArrayList<Integer>();
		int r = 0;
		int t = num;
		int sum = 0;
//		boolean isArmstrong = false;
		
		//Get each digit from the num and store them in the ArrayList
		while (t > 0) {
			r = t%10;
			t = t/10;
			digits.add(r);
		}
		
		
		for (int i = 0; i < digits.size(); i++) {
			sum = (int) (sum + Math.pow(digits.get(i), digits.size()));
		}
		
		return sum == num ;
		
//		if (sum == num) {
////			System.out.println("The number " + num + " is an Armstrong number.");
//			isArmstrong = true;
//		}
//		
////		System.out.println("The number " + num + " is not an Armstrong number.");
//		return isArmstrong;
		
	}
	
	public static void findArmstrongnumber(int fromNum, int toNum) {
		System.out.println("From " + fromNum + " to " + toNum + " , all armstrong numbers are:");
		
		for (int i = fromNum; i <= toNum; i++) {
			if (isArmstrongNum(i)) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		
		System.out.println();
		
		//isArmstrongNum(1634);
		
		findArmstrongnumber(1000, 10000);

	}

}
