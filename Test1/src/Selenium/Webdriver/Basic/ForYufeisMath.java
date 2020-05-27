package Selenium.Webdriver.Basic;


public class ForYufeisMath {
	
	//Why need iCount-1? 1st time is to get the input number "1". So real calculation starts from 2nd time.
	
	public int yufeiQuestion(int iCount) {
		//int iCount =50;
		int i = 1;
		int number = 1;
		
		while (i <= (iCount-1)) {
			//int number;
			int tens = number / 10;
			int ones = number % 10;
			if (tens == 0) {
				number = 2 * number;
			} else {
			number = tens + ones;
			}
			i++; 
			
		}
		return number;
	}
	
	public int yufeiQuestionImprove(int iCount) {
		//int iCount = 50;
		int i = 1;
		int j;
		int k = 1;
		int iNumber = 1;
		int number = 0;
		
		//Calculate when the number can be back to the initial number
		while (number != iNumber) {
			if (i == 1) {
				number = iNumber;
			}
			int tens = number / 10;
			int ones = number % 10;
			if (tens == 0) {
				number = 2 * number;
			} else {
				number = tens + ones;
			}
			i++;
		}
		
		j = i-1;
		System.out.println("After doing the calculateion " + j + " times, the number will back to initial.");
		
		//Calculate the final number
		int count = (iCount-1)%j;
		System.out.println("Basicly, only " + count + " times calcuation needed.");
		while (k <= count) {
			int tens = number / 10;
			int ones = number % 10;
			if (tens == 0) {
				number = 2 * number;
			} else {
				number = tens + ones;
			}
			k++;
		}
		
		return number;
		
	}
	
	
	// check if the number can back to initial.
	public int yufeiQuestionImprove1(int iNumber, int iCount) {
		//int iCount = 50;
		int i = 1;
		int j;
		int k = 1;
		//int iNumber = 1;
		int number = 0;
		int tens;
		int ones;
		
		System.out.println("The input number is " + iNumber + ". It needs to be calculated for " + iCount + " times.");
		
		//Calculate when the number can be back to initial number or never
			while (number != iNumber && i <= (iCount-1)) {
				if (i == 1) {
					number = iNumber;
				}
				tens = number/10;
				ones = number%10;
				if (tens == 0) {
					number = 2*number;
				} else {
					number = tens + ones;
				}
				i++;
			}
			
			//Check if number will never back to initial within iCount times calculation.
			// Or, if back to initial, then do the leftover times of calculation
			if (i > (iCount-1)) {
				
				return number; //The number was got when i-1
				
			} else {
				j = i-1;
				System.out.println("After doing the calculateion " + j + " times, the number will back to the original input number " + iNumber);
				
				//Calculate the final number with leftover times calculation
				int count = (iCount-1)%j;
				if (count == 0) {
					//The calculation times is an integral multiple. So the final number has been back to the original number.
					number = iNumber; 
					return number;
				} else {
					System.out.println("Basicly, only " + count + " times calcuation needed.");
					
					while (k <= count) {
						tens = number/10;
						ones = number%10;
					if (tens == 0) {
						number = 2*number;
					} else {
						number = tens + ones;
					}
					k++;
					}
					return number;
				}
				
			}
	}
	
	public static void main(String[] args) {
		ForYufeisMath obj = new ForYufeisMath();
		
		System.out.println("--- Results from Method 1 ---");
		System.out.println("The final number is " + obj.yufeiQuestion(50));
		System.out.println();
		
		System.out.println("--- Results from Method 2 ---");
		System.out.println("The final number is " + obj.yufeiQuestionImprove(50));
		System.out.println();
		
		System.out.println("--- Results from Method 3 ---");
		System.out.println("The final number is " + obj.yufeiQuestionImprove1(1, 50));
	}

}
