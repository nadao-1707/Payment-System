package com.sda.payment.payment_system;

import java.util.Scanner;

public class Donations implements service {
    @Override
    public void print(user user1, adminController admin) {
            System.out.println("choose service type:\n" +
                    "1-Cancer Hospital\n" +
                    "2-Schools\n" +
                    "3-NGOs (non profitable organizations)\n" );
            Scanner scan =new Scanner(System.in);
            int int1 = scan.nextInt();
            String type=" ";
            if(int1==1){
                type="Cancer Hospital";
            }
            else if(int1==2){
                type="Schools";
            }
            else if(int1==3){
                type="NGOs";
            }
            System.out.println("Enter the amount:");
            double amount = scan.nextDouble();
            transaction pay1=new payment(amount,user1,type);
            pay1.Transaction();
            admin.add(pay1);
    }
}
