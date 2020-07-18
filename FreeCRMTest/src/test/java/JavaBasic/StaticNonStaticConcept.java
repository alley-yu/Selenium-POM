package JavaBasic;

public class StaticNonStaticConcept {
	
//	Global Variables
	String name = "Alley";
	static int age = 41;
	
	public void sendMail() {
		System.out.println("sendMail method - Non Static");
	}
	
	public static void printMail() {
		System.out.println("printMail method - Static");
	}

	public static void main(String[] args) {
		
//		How to call static varaible/method
//		1. direct calling
		printMail();
		System.out.println("direct calling static var: " + age);
		
//		2. calling it by class name
		System.out.println("calling static method by class name");
		StaticNonStaticConcept.printMail();
		System.out.println("calling static var by class name");
		System.out.println("direct calling static var: " + StaticNonStaticConcept.age);
		
//		How to call non-static varaiable/method
//		Have to create object
		StaticNonStaticConcept obj = new StaticNonStaticConcept();
		System.out.println("Call non-static global variable name: " + obj.name);
		obj.sendMail();
		obj.printMail(); //It's ok, but with warning, static method should be accessed in a static way
		
	}

}
