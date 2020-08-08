package JavaInterviewQuestions;

public class RemoveJunkChar {

	public static void main(String[] args) {
		
		//Regular expression: [^a-zA-Z0123456789]
		String s = "test 东方大厦 Selenium$";
		String s1 = s.replaceAll(" ", "_");
		System.out.println(s1);
		String s2 = s.replaceAll("[^a-zA-Z0123456789]", "");
		System.out.println(s2);
		String s3 = s.replaceAll("[^a-zA-Z0123456789$]", "");
		System.out.println(s3);

	}

}
