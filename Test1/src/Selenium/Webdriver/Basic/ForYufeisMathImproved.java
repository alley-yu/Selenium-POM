package Selenium.Webdriver.Basic;

public class ForYufeisMathImproved {
	
	//Why need iCount-1? 1st time is to get the input number "1". So real calculation starts from 2nd time.
	//Here yufeiQuestion()doesn't need iCount -1 since this input "iCount" is the real calculation times after removing the repeating times.
	
	public int yufeiQuestion(int iNumber, int iCount) {
		//int iCount =50;
		int i = 1;
		int number = iNumber;
		
		while (i <= (iCount)) {
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
	
	// check if the number can back to initial.
	public int yufeiQuestionImprove1(int iNumber, int iCount) {
		//int iCount = 50;
		int i = 1;
		int j;
		//int k = 1;
		//int iNumber = 1;
		int number = 0;
		int oNumber;
		//int tens;
		//int ones;
		
		System.out.println("The input number is " + iNumber + ". It needs to be calculated for " + iCount + " times.");
		
		if (iCount == 1) {
			
			oNumber = iNumber;
			
		} else {
			
			//Calculate when the number can be back to initial number
			while (number != iNumber && i <= (iCount-1)) {
				if (i==1) {
					number = iNumber;
				}
				
				number = yufeiQuestion(number, (iCount-1));
				
				//tens = number/10;
				//ones = number%10;
				//if (tens == 0) {
				//	number = 2*number;
				//} else {
				//	number = tens + ones;
				//}
				
				i++;
			}
			
			//Check if number will never back to initial within iCount times calculation.
			// Or, if back to initial, then do the leftover times of calculation
			if (i > (iCount-1)) {
				
				//return the number if it hasn't been back to initial number
				oNumber = number;
				
			} else {
			
				j = i-1;
				println("After doing the calculateion " + j + " times, the number will back to the original input number " + iNumber);
			
				//Calculate the final number with leftover times calculation
				int count = (iCount-1)%(i-1);
				if (count == 0) {
					//The calculation times is an integral multiple. So the final number has been back to the original number.
					//number = iNumber; 
					//return number;
					oNumber = iNumber;
				} else {
				
					println("Basicly, only " + count + " times calcuation needed.");
					
					//yufeiQuestion(iNumber, count);
					//System.out.println("Now the number in method is " + yufeiQuestion(iNumber, count));
					
					//return yufeiQuestion(iNumber, count);
					oNumber = yufeiQuestion(iNumber, count);
				}
			}
		}
		return oNumber;
	}
	
	public static void println(String input) {
		
		System.out.println(input);
		
	}
					

	public static void main(String[] args) {
		
		ForYufeisMathImproved obj = new ForYufeisMathImproved();
		
		
		println("--- Results from Method 1 ---");
		//System.out.println("The final number is " + obj.yufeiQuestion(50));
		println("");
		
		println("--- Results from Method 2 ---");
		println("The final number is " + obj.yufeiQuestionImprove1(1, 50));
	}

}
