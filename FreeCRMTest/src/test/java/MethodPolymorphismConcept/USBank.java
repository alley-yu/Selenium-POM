package MethodPolymorphismConcept;

public interface USBank {
	
	int min_balance = 100;
	
	public void credit();
	
	public void debit();
	
	public void transferMoney();
	
	
	//For interface
	//Only method declaration, no method body
	//The varible defined in interface is static by default. Var value cannot be changed.
	//No static method declared in interface.
	//No main method in interface.
	//No object can be create from interface.
	//Interface is abstract in nature.

}
