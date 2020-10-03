package JavaInterviewQuestions;

public class CommonJavaInterviewQuest7 {
	
	public static void charFrequency(char c) {
		
		String sentence = "We can declare a two dimensional array and "
				+ "directly store elements at the time of its declaration.";
		int counter = 0;
		
		for (int i = 0; i < sentence.length(); i++) {
			if (c == sentence.charAt(i)) {
				counter += 1;
			}
		}
		
		System.out.println("There are " + counter + " " + c + " in the given string.");
	}

	public static void main(String[] args) {
		charFrequency('a');

	}

}
