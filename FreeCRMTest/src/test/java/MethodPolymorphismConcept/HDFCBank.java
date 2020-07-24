package MethodPolymorphismConcept;

public class HDFCBank extends Bank {
	
	//Child class of abstract class has to include and define all abstract methods coming from the parent abstract class
	
	public void loan() {
		System.out.println("HDFCBank --> load");
	}
	
	public void transferMoney() {
		System.out.println("HDFCBank --> TransferMoney");
	}
	
	public void fund() {
		System.out.println("HDFCBank --> Fund");
	}

}
