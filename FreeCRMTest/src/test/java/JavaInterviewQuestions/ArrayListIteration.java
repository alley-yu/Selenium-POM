package JavaInterviewQuestions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListIteration {
	
	public static void IterationWithLambdaExpression(ArrayList<String> shows) {
		System.out.println("----- 1. Using for each with lambda in Java 8 ------ ");
		
		shows.forEach(show -> {
			System.out.println(show);
		});
	}
	
	public static void IterationWithIterator(ArrayList<String> shows) {
		System.out.println("----- 2. Using Iterator ------ ");
		
		Iterator<String> tvShow = shows.iterator();
		while(tvShow.hasNext()) {
			String show = tvShow.next();
			System.out.println(show);
		}
		
	}
	
	public static void IterationWithLambdaForEachRemain(ArrayList<String> shows) {
		System.out.println("----- 3. Using Iterator and java 8 Lambda with forEachRemaining() ------ ");
		
		Iterator<String> tvShow = shows.iterator();
		tvShow.forEachRemaining(show -> {
			System.out.println(show);
		});
	}
	
	public static void IterationWithForEach(ArrayList<String> shows) {
		System.out.println("----- 4. Using for each loop ------ ");
		
		for(String show: shows) {
			System.out.println(show);
		}
		
	}
	
	public static void IterationWithForLoop(ArrayList<String> shows) {
		System.out.println("----- 5. Using for loop with index ------ ");
		
		for (int i = 0; i < shows.size(); i++) {
			System.out.println(shows.get(i));
		}
	}
	
	public static void IterationWithListIterator(ArrayList<String> shows) {
		System.out.println("----- 6. Using ListIterator to traverse both directions - backward ------ ");
		ListIterator<String> tvShow = shows.listIterator(shows.size());
		while(tvShow.hasPrevious()) {
			String show = tvShow.previous();
			System.out.println(show);
		}
	}
	
	public static void IterationWithListIterator1(ArrayList<String> shows) {
		System.out.println("----- 7. Using ListIterator to traverse both directions - forward ------ ");
		ListIterator<String> tvShow = shows.listIterator();
		while(tvShow.hasNext()) {
			String show = tvShow.next();
			System.out.println(show);
		}
	}

	public static void main(String[] args) {
		
		ArrayList<String> tvSeries = new ArrayList<String>();
		tvSeries.add("Grey's Anatomy");
		tvSeries.add("Scandal");
		tvSeries.add("Prison Break");
		tvSeries.add("Friends");
		
		IterationWithLambdaExpression(tvSeries);
		
		IterationWithIterator(tvSeries);
		
		IterationWithLambdaForEachRemain(tvSeries);
		
		IterationWithForEach(tvSeries);
		
		IterationWithForLoop(tvSeries);
		
		IterationWithListIterator(tvSeries);
		
		IterationWithListIterator1(tvSeries);

	}

}
