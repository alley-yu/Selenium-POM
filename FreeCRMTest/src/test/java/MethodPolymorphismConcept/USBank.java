package MethodPolymorphismConcept;

public interface USBank {
	
	int min_balance = 100; //still be treated as final and static varible even there is no "final/static"
	
	public void credit();
	
	public void debit();
	
	public void transferMoney();
	
	
	//For interface
	//Only method declaration, no method body - abstract method
	//The varible defined in interface is static by default. Var value cannot be changed.
	//No static method declared in interface.
	//No main method in interface.
	//No object can be create from interface.
	//Interface is abstract in nature.
	//only final and static varible can be defined in interface.
	

}
