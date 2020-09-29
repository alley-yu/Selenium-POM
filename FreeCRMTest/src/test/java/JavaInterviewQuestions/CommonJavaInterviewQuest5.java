package JavaInterviewQuestions;

public class CommonJavaInterviewQuest5 {
	
	public static String reverseSentence(String sentence) {

		
		String iniSentence = sentence.replace(".", "");
		String[] wordList = iniSentence.split(" ");
		String revSentence = "";
		
		for (int i = wordList.length-1; i >= 0; i--) {
			if(i != 0) {
				revSentence = revSentence + wordList[i] + " ";
			}else {
				revSentence = revSentence + wordList[i] + ".";
			}
		}
		
		return revSentence;
		
	}
	
	public static String reverseSentence1(String sentence) {
		
		if (sentence.isEmpty())
			return sentence;
		
		return reverseSentence1(sentence.substring(1)) + sentence.charAt(0);
	}

	public static void main(String[] args) {
		
		String sentence = "I'm coding.";
		
		System.out.println("The sentence you input is: " + sentence );
		
		System.out.println("After reversing word by word, it is: " + reverseSentence(sentence));
		
		System.out.println("After completely reversed, it is: " + reverseSentence1(sentence));

	}

}
