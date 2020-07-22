package MethodPolymorphismConcept;

public class TestBanks {

	public static void main(String[] args) {
		
		HSBCBank b = new HSBCBank();
		b.credit();
		b.debit();
		b.transferMoney();
		b.mutualFund();
		b.carLoan();
		b.educationLoan();
		
		System.out.println("Child class object can be referenced to Parent class reference variable - dynamic ploymorphism.");
		System.out.println("Parent Class --> USBank");
//		Child class object can be referenced to Parent class reference variable - dynamic ploymorphism.
		USBank a1 = new HSBCBank();
		a1.credit();
		a1.debit();
		a1.transferMoney();
		//carLoan() and educationLoan cannot be accessible because of dynamic ploymorphism.
		
		System.out.println("Parent Class --> BrazilBank");
		BrazilBank a2 = new HSBCBank();
		a2.mutualFund();

	}

}
