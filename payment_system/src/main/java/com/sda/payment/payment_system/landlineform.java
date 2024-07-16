package com.sda.payment.payment_system;


public class landlineform implements serviceForm {
    public void showform(user user1,adminController admin) {
        service s=new Landline();
        s.print(user1,admin);
    }

}
