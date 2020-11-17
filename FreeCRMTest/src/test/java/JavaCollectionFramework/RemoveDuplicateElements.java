package JavaCollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateElements {

	public static void main(String[] args) {
		
		ArrayList<Integer> NumList = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 1, 4, 6, 8, 7, 9, 2, 9, 4));
		
		//1. LinkedHashSet
		LinkedHashSet<Integer> NumSetNoDup = new LinkedHashSet<Integer>(NumList);
		
		ArrayList<Integer> NumListNoDup = new ArrayList<Integer>(NumSetNoDup);
		
		System.out.println(NumListNoDup);
		
		//2. JDK 8 - steam method
		
		List<Integer> NumListNoDup1 = NumList.stream().distinct().collect(Collectors.toList());
		
		System.out.println(NumListNoDup1);

	}

}
