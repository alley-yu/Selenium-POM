package JavaInterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonJavaInterviewQuest8 {
	
	public static void countVowelConsonant(String sentence) {
		
		int vowelNum = 0, consonantNum = 0, otherCharNum = 0;
		
		for (int i = 0; i < sentence.length(); i++){
			
			char c = sentence.charAt(i);
			
			if ((c >= 'a' && c <= 'z')||(c >='A' && c <='Z')) {
				
				switch(c) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					vowelNum ++;
					break;
				default:
					consonantNum ++;
					break;
				}
			} else {
				otherCharNum ++;
			}
		}
		
		System.out.println("There are " + vowelNum + " vowels in the sentence.");
		System.out.println("There are " + consonantNum + " consonants in the sentence.");
		System.out.println("There are " + otherCharNum + " others in the sentence.");
	}
	

	public static List<String> orderTwoWords(String word1, String word2) {
		
		String fWord = word1, lWord = word2;
		List<String> wordsOrderedList = new ArrayList<String>();
		
		if (fWord.equals(lWord)) {
			System.out.println("Two words are same.");

		} else {
			int i = 0;
			while ((i <= (fWord.length() - 1)) && (i <= (lWord.length() - 1))) {
				if (fWord.charAt(i) > lWord.charAt(i)) {
					fWord = word2;
					lWord = word1;
					break;
				} else if (fWord.charAt(i) == lWord.charAt(i)){
					i++;
				} else {
					break;
				}
			}
			//handle 2 words with different lenth, but same beginning part, like abcd, abc, the shorter one lined in front
			//Only need to take care i=word2.length, then swap fWord and lWord.
			//Because when i=word1.length, word1 has been put in the first by default.(fWord = word1)
			if (i == lWord.length()) {
				fWord = word2;
				lWord = word1;
			}
			
		}
		
//		System.out.println(fWord + ", " + lWord);
		
		wordsOrderedList.add(fWord);
		wordsOrderedList.add(lWord);
		
		return wordsOrderedList;

	}
	
	public static void orderWordsInLexicographics(String[] wordsList) {
	
		for (int i = 0; i < wordsList.length - 1; i++) {
			for (int j = i + 1; j < wordsList.length; j++) {
				List<String> wordsByOrder = orderTwoWords(wordsList[i], wordsList[j]);
				wordsList[i] = wordsByOrder.get(0);
				wordsList[j] = wordsByOrder.get(1);
			}
		}
		
		for (int i = 0; i < wordsList.length; i++) {
			System.out.println(wordsList[i] + " ");
		}
	}


	public static void main(String[] args) {
		
		String sentence = "Selenium WebDriver Interview Questions Part 3: ";
		
		countVowelConsonant(sentence);
		
//		orderTwoWords("cacb", "caab");
		
		String[] wordsList = {"bag", "cake", "cat", "apple", "cake", "applesauce"};
		orderWordsInLexicographics(wordsList);
	

	}

}
