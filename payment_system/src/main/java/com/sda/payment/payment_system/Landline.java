package com.sda.payment.payment_system;

import java.util.Scanner;

public class Landline implements service {
    public void print(user user1,adminController admin)
    {
        System.out.println("choose service type:\n" +
                "1-Monthly Receipt\n" +
                "2-Quarter Receipt\n" );
        Scanner scan =new Scanner(System.in);
        int int1 = scan.nextInt();
        String type=" ";
        if(int1==1){
            type="Monthly Receipt";
        }
        else if(int1==2){
            type="Quarter Receipt";
        }
        System.out.println("enter the amount:");
        double amount = scan.nextDouble();
        transaction pay1=new payment(amount,user1,type);
        pay1.Transaction();
        admin.add(pay1);
}
}
