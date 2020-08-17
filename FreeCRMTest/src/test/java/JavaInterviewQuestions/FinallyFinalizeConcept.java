package JavaInterviewQuestions;

public class FinallyFinalizeConcept {
	
	//finally{} is the code which have to execute within a method. 
	//Usually it'll be used to unlock/release something when exception happens.
	//finalize() could run when doing garbage clean, but still depends on if it's neccessary to clean.

	@Override
	public void finalize(){
		System.out.println("finalize method");
	}
	
	public static void main(String[] args) {
		
		test1();
		test2();
		division();
		division1(); //exception cannot be caught since arithmetic exception is expected here.
		
		FinallyFinalizeConcept f1 = new FinallyFinalizeConcept();
		FinallyFinalizeConcept f2 = new FinallyFinalizeConcept();
		
		f1 = null; //object without reference
		f2 = null;
		
		System.gc();
	}
	
	public static void test1() {
		
		try {
			System.out.println("inside test1 method");
			throw new RuntimeException("exception - test");
		}catch(Exception e) {
			System.out.println("inside catch block");
		}
		
		finally {
			System.out.println("1 inside finally block");
		}
	}
	
	public static void test2() {
		
		try {
			System.out.println("inside test2 method");
		}
		
		finally {
			System.out.println("2 inside finally block");
		}
		
	}
	
	public static void division() {
		int i = 10;
		try {
			System.out.println("Inside try block");
			int k = i/0;
		}catch(ArithmeticException e) {
			System.out.println("Inside catch block");
			System.out.println("divide by zero error");
		}
		
		finally {
			System.out.println("finally block: even exception happens");
		}
	}
	
	public static void division1() {
		int i = 10;
		try {
			System.out.println("Inside try block");
			int k = i/0;
		}catch(NullPointerException e) { //exception cannot be caught since arithmetic exception is expected here.
			System.out.println("Inside catch block (NullPointerException)");
			System.out.println("divide by zero error (NullPointerException)");
		}
		
		finally {
			System.out.println("finally block: even exception happens");
		}
	}
	
	

}
