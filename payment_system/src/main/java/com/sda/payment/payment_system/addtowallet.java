package com.sda.payment.payment_system;

public class addtowallet extends transaction {

	public addtowallet(double amount, user useron) {
		Amount=amount;
        this.user1=useron;
        transactiontype="add to wallet";
	}

	@Override
	public void Transaction() {
		
	}

}
