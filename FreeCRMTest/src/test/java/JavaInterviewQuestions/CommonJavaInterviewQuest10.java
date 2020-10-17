package JavaInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonJavaInterviewQuest10 {
	
	public static String[] listToArray1(List<String> wordList) {
		
		String[] wordArray = new String[wordList.size()];
		for (int i = 0; i < wordList.size(); i++) {
			wordArray[i] = wordList.get(i);
		}
		
//		for (String word: wordArray) {
//			System.out.print(word + " ");
//		}
		
		return wordArray;
	}
	
	public static void listToArray2(List<String> wordList) {
		
		//toArray(T[] a) method:
		//T: Type parameter
		//a: A parameter, the array into which the elements of the list will be stored. Otherwise, a new array of the same type will be allocated.
		
		String[] wordArray = wordList.toArray(new String[0]);
		
		for (String word: wordArray) {
			System.out.print(word + " ");
		}
	}
	
	public static void arrayToList1(String[] wordArray) {
		
		List<String> wordList = new ArrayList<String>();
			
		for (String word: wordArray){
			wordList.add(word);
		}
		
		for (String word: wordList) {
			System.out.print(word + " ");
		}
		
	}
	
	public static void arrayToList2(String[] wordArray) {
		
		List<String> wordList = Arrays.asList(wordArray);
		
		for (String word: wordList) {
			System.out.print(word + " ");
		}
		
	}

	public static void main(String[] args) {
		
		List<String> wordList = new ArrayList<String> ();
		wordList.add("I");
		wordList.add("am");
		wordList.add("coding");
		wordList.add("with");
		wordList.add("Java");
		
//		listToArray1(wordList);
//		System.out.println();
//		
//		listToArray2(wordList);
		
		arrayToList1(listToArray1(wordList));
		System.out.println();
		
		arrayToList2(listToArray1(wordList));
		System.out.println();
		
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		

	}

}
