package JavaInterviewQuestions;

public class CheckAllNumeric {
	
	public static boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}
	
	public static boolean isAllNumeric(CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
			
		for (int i = 0; i < cs.length(); i++) {
			if(!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
			
		return true;
		
	}

	public static void main(String[] args) {
		
		String strToCheck = "12345";
		System.out.println("The input " + strToCheck + " is All Numeric: " +isAllNumeric(strToCheck));
		


	}

}
