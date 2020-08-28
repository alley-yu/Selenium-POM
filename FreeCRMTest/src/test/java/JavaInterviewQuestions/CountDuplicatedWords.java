package JavaInterviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CountDuplicatedWords {
	
	public static void duplicatedWords(String sentence) {
		
		System.out.println("String input is: " + sentence);
		System.out.println("Below are duplicated words with their duplicated times.");
		
		String words[] = sentence.split(" ");
		
		Map<String, Integer> wordsCount = new HashMap<String, Integer>();
		
		//Convert all words to lowercase
		for(String word: words) {
			if(!wordsCount.containsKey(word.toLowerCase())){
				wordsCount.put(word.toLowerCase(), 1);
			}else {
				wordsCount.put(word.toLowerCase(), wordsCount.get(word.toLowerCase()) + 1);
			}
		}
		
//		for (int i = 0; i < words.length; i ++) {
//			if (!wordsCount.containsKey(words[i])) {
//				wordsCount.put(words[i], 1);
//			}else {
//				wordsCount.put(words[i], wordsCount.get(words[i]) + 1);
//			}	
//		}
		
		System.out.println("------ Use entrySet to traverse all elements from amp ---------");
		
		for(Entry<String, Integer> word: wordsCount.entrySet()) {
			if(word.getValue() > 1) {
				System.out.println(word.getKey() + ": " + word.getValue() );
			}
		}
		
		//forEach method to traverse all elements in the HashMap
		//wordsCounter.forEach((k, v) -> System.out.println(k + ": " + v));
		
		System.out.println("------ Use keySet to extract all keys from map ---------");
		
		Set<String> wordsInString = wordsCount.keySet();
		for(String word: wordsInString){
			if(wordsCount.get(word) > 1) {
				System.out.println(word + ": " + wordsCount.get(word));
			}
		}
	}

	public static void main(String[] args) {
		
		duplicatedWords("Owen is doing homework owen is doing his homework Owen is doing homework Yufei is doing her project");
		

	}

}
