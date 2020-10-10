package JavaInterviewQuestions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonJavaInterviewQuest9 {
	
	public static void roundingNum(double number, int places) {
		
		double scale = Math.pow(10, places);
		double result = Math.round(number * scale)/scale;
		
		System.out.println(result);
	}


	public static void main(String[] args) throws ParseException {
		
		//remove space in string
		String str = "We are making Jazz Music and Beautiful Bossa Nova Music for relaxation";
		System.out.println(str.replace(" ", ""));
		
		//Convert String to Date
		String strDate = "06/21/1979";
		Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(strDate);
		System.out.println(date1);
		
		//round to n decimal places
		roundingNum(3.1415927, 5);
		

	}

}
