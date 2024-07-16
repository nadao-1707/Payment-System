package com.sda.payment.payment_system;

import java.util.Scanner;
public class payment extends transaction{
    public payment(double amount,user user1,String type){
        Amount=amount;
        this.user1=user1;
        this.servicetype=type;
        transactiontype="payment transaction";
        ok=false;
    } 
    public payment() {
	}
	public void Transaction() {
        System.out.println("choose payment method:\n" +
                "1-wallet\n" +
                "2-credit card\n" +
                "3-cash on delivery\n");
        Scanner scan =new Scanner(System.in);
        int int1 = scan.nextInt();
        if(int1==1){
            user1.wallet-=Amount;
            System.out.println("you have paid by your wallet");
            ok=true;
        }
        else if(int1==2){
            System.out.println("you have paid by credit card");
            ok=true;
        }
        else if(int1==3) {
            System.out.println("you have paid by cash on delivery");
            ok=true;
        }
    }
}
