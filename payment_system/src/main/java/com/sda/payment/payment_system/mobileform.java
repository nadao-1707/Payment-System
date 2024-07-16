package com.sda.payment.payment_system;

public class mobileform implements serviceForm{
    @Override
    public void showform(user user1,adminController admin) {
        service s=new mobile();
        s.print(user1,admin);
    }
}
