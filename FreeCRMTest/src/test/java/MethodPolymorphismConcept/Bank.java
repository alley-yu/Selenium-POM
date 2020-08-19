package MethodPolymorphismConcept;

public abstract class Bank {
	
	//Partial abstraction
	//For those abstract class, hiding implementation logic
	//abstract class can have abstract method and non-abstract method
	//abstract method only have method declaration, no body
	//cannot create object of abstract class
	
	
	public abstract void loan();
	
	public abstract void transferMoney();
	
	
	
	//non-abstract methods
	public void credit() {
		System.out.println("Bank --> Credit");
	}
	
	public void debit() {
		System.out.println("Bank --> Debit");
	}

}
