package JavaInterviewQuestions;

public class CommonJavaInterviewQuest6_ReverseMatrix{
	
	public static void printArray(int[][] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void reverseSymetricalArr(int[][] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int j = arr[i].length - 1;
			
			while(i <= j && j < arr[i].length) {
				if(i != j) {
				arr[j][i] = arr[i][j] + arr[j][i];
				arr[i][j] = arr[j][i] - arr[i][j];
				arr[j][i] = arr[j][i] - arr[i][j];
				}
				j--;
			}
		}
		printArray(arr);
	}
	
	public static void reverseRegArr(int[][] arr) {
		
		System.out.println("The array I got is: ");
		printArray(arr);
		
		int row = arr.length;
		int column = arr[0].length;
		int[][] reversedArr = new int[column][row];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				reversedArr[j][i] = arr[i][j]; 
			}
		}
		printArray(reversedArr);
	}

	public static void main(String[] args) {
		
		int[][] arr = new int[3][3];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 1;
		arr[1][1] = 2;
		arr[1][2] = 3;
		arr[2][0] = 1;
		arr[2][1] = 2;
		arr[2][2] = 3;
//		arr[3][0] = 5;
//		arr[3][1] = 6;
//		arr[3][2] = 7;
		
		
		System.out.println("The original matrix is: ");
		printArray(arr);
		
		System.out.println("After switching, the matrix is: ");
		
		reverseSymetricalArr(arr);
		
		reverseRegArr(arr);
		
		
		
			
		
		


	}

}
