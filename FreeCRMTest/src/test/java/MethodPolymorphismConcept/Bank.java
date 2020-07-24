package MethodPolymorphismConcept;

public abstract class Bank {
	
	//Partial abstraction
	//abstract class can have abstract method and non-abstract method
	//abstract method only have method declaration, no body
	
	
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
