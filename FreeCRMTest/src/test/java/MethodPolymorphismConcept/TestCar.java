package MethodPolymorphismConcept;

public class TestCar {

	public static void main(String[] args) {
		
//		Static polymorphism, compile-time polymorphism 
		BMW b = new BMW();
		b.start(); //Use start method from child level(BMW) instead of parent level(Car).
		b.theftSafety();
		b.stop();
		b.refuel();
		b.engine();
		
		System.out.println("**********");
		
//		parent class only can access its own method, no access to its child method
		Car c = new Car();
		c.start();
		c.stop();
		c.refuel();
		
		System.out.println("**********");
		
//		Child class object can be referred by parent class reference varible - dynamic polymorphism or run-time polymorphism
//		Only common method can be accessed + parent class method.
//		When common method be accessed, child class method will be used.
		
		//Top Casting
		Car c1 = new BMW();
		c1.start();
		c1.stop();
		c1.refuel();
		//c1.theftsafety(); It is not accessible because it's the property only for child class BMW.
		
	}

}


