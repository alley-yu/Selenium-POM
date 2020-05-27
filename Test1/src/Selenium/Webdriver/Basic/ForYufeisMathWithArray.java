package Selenium.Webdriver.Basic;

public class ForYufeisMathWithArray{
	
	static int inLoopCounts = 0;
	
	public int[] resultsWithArray(int iNumber, int iCount) {
		int i = 1;
		int number = iNumber;
		int [] resultsWithArray = new int[19]; //array[1]-[18] could have values

		
		while (i <= (iCount)) {
			if (i == 1 ) {
				resultsWithArray[number] = i;
			} else {
				int tens = number / 10;
				int ones = number % 10;
				if (tens == 0) {
					number = 2 * number;
				} else {
					number = tens + ones;
				}
				if (resultsWithArray[number] != 0) {
					inLoopCounts = i-1;
					System.out.println("After " + inLoopCounts + " times calcuation, number will be back to the initial number  " + iNumber);
					return resultsWithArray;
				}
			
				resultsWithArray[number] = i;

				}
				i++;
			}
		
		return resultsWithArray;
	}
	
	
	public int findResult(int arr[], int t) {
		int len = arr.length;
		int i =0;
		
		
		while (i < len) {
			if (arr[i] == t) {
				return i;
			} else {
				i = i+1;
			}
		}
		return -1;
	}
	

	public static void main(String[] args) {
		
		int iNumber = 1;
		int iCount = 46;
		
		ForYufeisMathWithArray obj = new ForYufeisMathWithArray();

		int my_array[] = obj.resultsWithArray(iNumber, iCount);
		
		if (inLoopCounts != 0) {
			int calCounts = iCount%inLoopCounts;
			if (calCounts == 0) {
				System.out.println("The result is the last time of the loop  calclation: " + obj.findResult(my_array, inLoopCounts));
			} else {
				System.out.println("The result is: " + obj.findResult(my_array, calCounts));
			}
		} else  {
			System.out.println("The result is: " + obj.findResult(my_array, iCount));
		}
		
	}

}
