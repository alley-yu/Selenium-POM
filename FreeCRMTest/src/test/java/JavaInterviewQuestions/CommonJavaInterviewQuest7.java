package JavaInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class CommonJavaInterviewQuest7 {
	
	public static void charFrequency1(String sentence, char c) {
		
		int counter = 0;
		
		for (int i = 0; i < sentence.length(); i++) {
			if (c == sentence.charAt(i)) {
				counter += 1;
			}
		}
		
		System.out.println("The character " + c + " was shown " + counter + " times" + " in the given string.");
	}
	
	public static Map<Character, Integer> eachCharFreqInString(String sentence) {
		
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		
		for (int i = 0; i < sentence.length(); i++) {
			char currentChar = sentence.charAt(i);
			if (charMap.get(currentChar) == null) {
				charMap.put(currentChar, 1);
			} else {
				charMap.put(currentChar, charMap.get(currentChar) + 1);
			}
		}
		
//		System.out.println(charMap);
		return charMap;
	}
	
	public static void charFrequency2(Map<Character, Integer> charFreqMap, char c) {
		
		System.out.println("The character " + c + " was shown " + charFreqMap.get(c) + " times in the given string.");
		
	}

	public static void main(String[] args) {
		
		String sentence = "We can declare a two dimensional array and "
				+ "directly store elements at the time of its declaration.";
		char c = 'a';
		
		charFrequency1(sentence, c);
		
		Map<Character, Integer> charFreqMap = eachCharFreqInString(sentence);
		charFrequency2(charFreqMap, c);

	}

}
