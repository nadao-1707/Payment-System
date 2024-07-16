package com.sda.payment.payment_system;

import java.util.Scanner;
public class Admin implements approv
{
    public int Password;
    public transaction[] arr;
    public Discount[] d;


    public Admin() {
    	Password=5555;
        d=new Discount[50];
        arr=new transaction[50];
        for(int i=0;i<50;i++) {
        	d[i]=new spacific();
        	arr[i]=new payment();
        }
        for(int i=0;i<50;i++){
            arr[i].transactiontype=" ";
            arr[i].servicetype=" ";
            arr[i].user1=new user();
            d[i]=null;
        }
    }

    @Override
    public void Transaction() {
        for(int i=0;i<50;i++){
            if(arr[i].ok==false && arr[i].transactiontype=="refund transaction"){
                System.out.println(arr[i].user1.username+ "  " +arr[i].Amount + "  " +arr[i].servicetype );
                System.out.println("1-accept\n" +
                        "2-reject\n");
                Scanner scan =new Scanner(System.in);
                int choice = scan.nextInt();
                if(choice==1){
                    arr[i].Transaction();
                    arr[i].ok=true;
                }
                else if(choice==2){
                    continue;
                }
            }
        }
    }

}
