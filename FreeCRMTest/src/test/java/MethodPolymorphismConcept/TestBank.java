package MethodPolymorphismConcept;

public class TestBank {

	public static void main(String[] args) {
		
		HDFCBank hb = new HDFCBank();
		hb.loan();
		hb.transferMoney();
		hb.credit();
		hb.debit();
		hb.fund();
		
		Bank b = new HDFCBank();
		b.loan();
		b.transferMoney();
		b.credit();
		b.debit();

	}

}
