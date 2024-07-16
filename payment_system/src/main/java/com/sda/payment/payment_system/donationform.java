package com.sda.payment.payment_system;

public class donationform implements serviceForm{
    @Override
    public void showform(user user1, adminController admin) {
        service s=new Donations();
        s.print(user1,admin);
    }
}
