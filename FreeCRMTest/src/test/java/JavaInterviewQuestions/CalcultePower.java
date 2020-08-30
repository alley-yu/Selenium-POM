package JavaInterviewQuestions;

public class CalcultePower {
	
	public static long powerCalculation(int baseNum, int powerNum) {
	
		long result = 1;
		for (int i = 1; i <= powerNum; i++) {
			result *= baseNum;
		}
		
		return result;
	}
	
	public static long powerCalculation1(int baseNum, int powerNum) {
		long result;
		
		if (powerNum%2 != 0) {
			result = baseNum;
		}else {
			result =1;
		}
		
		for (int i = 1; i <= powerNum/2; i++) {
			result = result * baseNum * baseNum;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		int base = 2;
		int power = 11;
		
		System.out.println(base + "^" + power + " = " + powerCalculation(base, power));
		System.out.println(base + "^" + power + " = " + powerCalculation1(base, power));

	}

}
