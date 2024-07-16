package com.sda.payment.payment_system;

public abstract class transaction {

    public double Amount;
    public user user1;
    public String servicetype;
    public String transactiontype;
    public boolean ok;

    public transaction() {
        Amount = 0;
        servicetype = " ";
        transactiontype = " ";
        ok = false;
    }

    public abstract void Transaction();
}
