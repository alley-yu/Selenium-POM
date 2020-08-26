package JavaInterviewQuestions;

public class aBMW extends aCar {

	//1. start() method cannot override the start()method from its parent class Car, which is static.
	
//	public void start() {
//		System.out.println("BMW -- start");
//		
//	}
	
	//2. if making it static (in child class), no error any more, it can be used.
	//but this method would be independent method, which is not belogning to BMW related object.
	//This is called, Method Hiding.
	
	public static void start() {
		System.out.println("BMW -- start -- method hiding");
		
	}
	
	public void stop() {
		System.out.println("BMW -- stop");
	}
}
