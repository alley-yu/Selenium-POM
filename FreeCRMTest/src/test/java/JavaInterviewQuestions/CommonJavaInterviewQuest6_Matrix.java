package JavaInterviewQuestions;

public class CommonJavaInterviewQuest6_Matrix{
	
	public static void printArray(int[][] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void transposeSymetricalArr(final int[][] arr) {
		
		int[][] transposedArr = arr.clone();
		
		for(int i = 0; i < transposedArr.length; i++) {
			int j = transposedArr[i].length - 1;
			
			while(i <= j && j < transposedArr[i].length) {
				if(i != j) {
				transposedArr[j][i] = transposedArr[i][j] + transposedArr[j][i];
				transposedArr[i][j] = transposedArr[j][i] - transposedArr[i][j];
				transposedArr[j][i] = transposedArr[j][i] - transposedArr[i][j];
				}
				j--;
			}
		}
		printArray(transposedArr);
	}
	
	public static void transposeRegArr(final int[][] arr) {
		
		System.out.println("The array I got is: ");
		printArray(arr);
		
		int row = arr.length;
		int column = arr[0].length;
		int[][] transposedArr = new int[column][row];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				transposedArr[j][i] = arr[i][j]; 
			}
		}
		printArray(transposedArr);
	}
	
	public static void matrixAddition(int[][] arr1, int[][] arr2) {
		
		int row1 = arr1.length;
		int column1 = arr1[0].length;
		int row2 = arr2.length;
		int column2 = arr2[0].length;
		int[][] matrixSum = new int[row1][column2];
		
		if(row1 == row2 && column1 == column2) {
			for(int i = 0; i < row1; i++) {
				for(int j = 0; j < column1; j++) {
					matrixSum[i][j] = arr1[i][j] + arr2[i][j];
				}
			}
			
			printArray(matrixSum);
			
		}else {
			System.out.println("Please input two matrices with same dimentions.");
		}
	}
	
	public static void matrixMultiply(int[][] arr1, int [][] arr2) {
		
		int [][] matrix1;
		int [][] matrix2;
		
		if (arr1[0].length == arr2.length) {
			
			matrix1 = arr1.clone();
			matrix2 = arr2.clone();
			
			System.out.println("1st matrix is: ");
			printArray(matrix1);
			System.out.println("2nd matrix is: ");
			printArray(matrix2);
			System.out.println("The product of the 2 matrices is: ");
			calculateMatricesProduct(matrix1, matrix2);
			
		} else if (arr1.length == arr2[0].length) {
			
			matrix1 = arr2.clone();
			matrix2 = arr1.clone();
			
			System.out.println("1st matrix is: ");
			printArray(matrix1);
			System.out.println("2nd matrix is: ");
			printArray(matrix2);
			System.out.println("The product of the 2 matrices is: ");
			calculateMatricesProduct(matrix1, matrix2);
			
		} else {
			System.out.println("For matrix multiplication to take place, the number of columns of the first matrix must be equal to the number of rows of the second matrix.");
			System.out.println("Your 2 matrices cannot be multiplied with each other. Please re-input. ");
		}
		
	}
	
	public static void calculateMatricesProduct(int[][] matrix1, int[][] matrix2) {
		
		int row = matrix1.length, col = matrix2[0].length;
		int [][] product = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				product[i][j] = 0;
				for (int k = 0; k < matrix2.length; k++) {
					product[i][j] = product[i][j] + matrix1[i][k] * matrix2[k][j];
				}
			}
		}
		printArray(product);

	}
	
	
	
	public static void main(String[] args) {
		
		int[][] matrix = {	{1, 2, 3},
							{1, 2, 3},
							{1, 2, 3}
						};
		
		int[][] matrix1 = {	{1, 2, 3},
							{1, 2, 3},
							{1, 2, 3}
						};
		
		int[][] matrix2 = {	{1, 2, 3},
							{1, 2, 3},
							{1, 2, 3}
						};
		
		int[][] matrix3 = {	{1, 2, 3, 4},
							{1, 2, 3, 4},
							{1, 2, 3, 4}
						};
		
		
		System.out.println("The original matrix is: ");
		printArray(matrix);
		
		System.out.println("After transposing, the matrix is: ");
		
		transposeSymetricalArr(matrix);
		
		transposeRegArr(matrix);
		
		System.out.println("-------- Matrix Addition -----------");
		
		matrixAddition(matrix1, matrix2);
		
		System.out.println("-------- Matrix Multiplication -----------");
		
		matrixMultiply(matrix2, matrix3);
		
			
		
		


	}

}
