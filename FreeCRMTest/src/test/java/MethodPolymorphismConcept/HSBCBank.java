package MethodPolymorphismConcept;

public class HSBCBank implements USBank, BrazilBank {
	
//	Mutiple inheritance from USBank and BrazilBank
//	Child class HSBCBank has to override all methods from its interfaces, but still can have its own method.
	
	public void credit() {
		System.out.println("HSBCBank --> Credit");
	}
	
	public void debit() {
		System.out.println("HSBCBank --> Debit");
	}
	
	public void transferMoney() {
		System.out.println("HSBCBank --> TransferMoney");
	}
	
	public void mutualFund() {
		System.out.println("HSBCBank --> MutualFund");
	}
	
	public void educationLoan() {
		System.out.println("HSBCBank --> EducationLoan");
	}
	
	public void carLoan() {
		System.out.println("HSBCBank --> CarLoan");
	}

}
