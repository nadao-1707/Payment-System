package com.sda.payment.payment_system;

public class refund extends transaction implements approv{
    public refund(double amount,user user){
        Amount=amount;
        this.user1=user;
        transactiontype="refund transaction";
        ok=false;
    }
    @Override
    public void Transaction() {
        user1.wallet+=Amount;
        System.out.println("sucessful refund");
    }
}
