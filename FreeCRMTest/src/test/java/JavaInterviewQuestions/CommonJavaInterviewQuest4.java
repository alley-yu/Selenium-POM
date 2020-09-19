package JavaInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class CommonJavaInterviewQuest4 {
	
	public static int binaryToDecimal(String binaryStr) {
		
		int decimalNum = 0;
		
		for (int i = 0; i < binaryStr.length(); i++) {
			decimalNum += Character.getNumericValue(binaryStr.charAt(i)) * (int)Math.pow(2, binaryStr.length()-1-i);
		}
		System.out.println("The decimal number of binary number " + binaryStr + " is: " + decimalNum);
		return decimalNum;
	}
	
	public static int binaryToDecimal1(String binaryStr) {
		
		int decimalNum = 0;
		
		decimalNum = Integer.parseInt(binaryStr, 2);
		System.out.println("The decimal number of binary number " + binaryStr + " is: " + decimalNum);
		return decimalNum;
	}
	
	public static int binaryToDecimal(int binaryNum) {
		
		int iniNum = binaryNum;
		int decimalNum = 0;
		int lastDigit;
		int position = 0;
		
		while(true) {
			if (binaryNum == 0) {
				break;
			}else {
				lastDigit = binaryNum%10;
				decimalNum += lastDigit * (int)Math.pow(2, position);
				binaryNum = binaryNum/10;
			}
			position ++;
		}
		
		System.out.println("The decimal number of binary number " + iniNum + " is: " + decimalNum);
		return decimalNum;
	}
	
	public static String decimalToBinary(int num) {
		
		int decimalNum = num;
		List<Integer> binaryList = new ArrayList<Integer>();
		String binary = "";
		
		if (num == 0) {
			binary = "0";
			
		} else {
			while (num != 0 ) {
				binaryList.add(num%2);
				num = num/2;
			}
			
			for (int i = binaryList.size()-1; i >= 0; i--) {
				binary = binary + binaryList.get(i);
			}
		}
		
		System.out.println("The decimal number " + decimalNum + " can be converted to binary number " + binary);
		return binary;
		
	}

	public static void main(String[] args) {
		
		binaryToDecimal("10011011");
		binaryToDecimal1("10011011");
		binaryToDecimal(10011011);
		
		decimalToBinary(156);

	}

}
