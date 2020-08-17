package JavaInterviewQuestions;

public class SwapWithoutTemp {

	public static void main(String[] args) {
		
		int x = 5;
		int y = 10; 
		
//		//1. With temp var
//		int t = x;
//		x = y;
//		y = t;
		
//		//2. Without temp var, using +
//		x = x + y;
//		y = x - y;
//		x = x - y;
		
		//3. Without temp var, using */
		x = x*y;
		y = x/y;
		x = x/y;
		
		//4. Without temp var, using ^ Don't know this way
		
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
		String a = "Hello";
		String b = "World";
		
		a = a + b;
		b = a.substring(0, (a.length() - b.length()));
		a = a.substring(b.length());
		
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);

	}

}
