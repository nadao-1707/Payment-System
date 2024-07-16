package com.sda.payment.payment_system;

public class internetform implements serviceForm {
    @Override
    public void showform(user user1,adminController admin) {
        service s=new internet();
        s.print(user1,admin);
    }
}
