package JavaInterviewQuestions;

public class CalcultePower {
	
	public static long PowerCalculation(int baseNum, int powerNum) {
	
		long result = 1;
		for (int i = 1; i <= powerNum; i++) {
			result *= baseNum;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		int base = 2;
		int power = 5;
		
		System.out.println(base + "^" + power + " = " + PowerCalculation(base, power));
		

	}

}
