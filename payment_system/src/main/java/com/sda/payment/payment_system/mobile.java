package com.sda.payment.payment_system;

import java.util.Scanner;

public class mobile implements service {
    @Override
    public void print(user user1,adminController admin)
    {
        System.out.println("choose service type:\n" +
                "1-Vodafone\n" +
                "2-Orange\n" +
                "3-Etisalat\n" +
                "4-We\n");
        Scanner scan =new Scanner(System.in);
        int int1 = scan.nextInt();
        String type=" ";
        if(int1==1){
            type="Vodafone";
        }
        else if(int1==2){
            type="Orange";
        }
        else if(int1==3){
            type="Etisalat";
        }
        else if (int1==4) {
            type = "We";
        }
        System.out.println("enter the amount:");
        double amount = scan.nextDouble();
        transaction pay1=new payment(amount,user1,type);
        pay1.Transaction();
        admin.add(pay1);


}}
