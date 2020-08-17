package JavaInterviewQuestions;

public final class ParentClass {
	
	//1. final for varible: the varible will be constant, cannot be changed any more.
	//2. final for class: the class cannot have child class.
	//3. final for method of parent class: provent method being overridden. its child class cannot have same name method.
	//   (If the parent class -> mehtod is not final, its child class -> method with same name will override parent class -> mehtod.

	public final void start() {
		
		final int a = 5;
		//a = 10;
		
		System.out.println("Parent -- start method");
	}
		
}
