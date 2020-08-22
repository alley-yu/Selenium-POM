package JavaInterviewQuestions;

public class MainOverloadTest {
	
	//Mutiple main methods can exist, with different arguements.
	//JVM-Java Virtual Machine
	//When JVM runs, it will try to find main(String[] args) with public static void, then execute it.
	//After that, when the input matches with the arguements of certain main method, that method will be called.
	public static void main(String[] args) {
		System.out.println("test 1");

		main("abc");
		main(10);
		main(10, 20);
	}
	
	public static void main(String args) {
		System.out.println("test 2");
		main(10);
	}
	
	public static void main(int a) {
		System.out.println("test 3");
		main(10, 20);
	}
	
	public static void main(int a, int b) {
		System.out.println("test 4");
	}

}
