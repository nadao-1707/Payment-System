package com.sda.payment.payment_system;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.payment.payment_system.Admin;
import com.sda.payment.payment_system.Discount;
import com.sda.payment.payment_system.ovarall;
import com.sda.payment.payment_system.refund;
import com.sda.payment.payment_system.spacific;
import com.sda.payment.payment_system.transaction;
import com.sda.payment.payment_system.user;

@Component
public class adminController {
    public Admin a;
    public adminController(){
        a=new Admin();
    }

    public boolean check(int s){
        if(a.Password==s){
            return true;
        }
        return false;
    }

    public void add(transaction trans){
        for(int i=0;i<50;i++){
            if(a.arr[i].transactiontype==" "){
                a.arr[i]=trans;
                break;
            }
        }
    }

    public void approve(){
        a.Transaction();
    }

    public String list(){
    	String out=" ";
        for(int i=0;i<50;i++){
        	if(a.arr[i].Amount==0.0) {
        		return out;
        	}
        	if(!(a.arr[i].transactiontype=="refund transaction" && a.arr[i].ok==false)) {
            out+=a.arr[i].user1.username+"    "+a.arr[i].transactiontype+"   "+a.arr[i].Amount+"\n";
        	}
        }
        return out;
    }

    public void refund(user user1,double amount){
        for(int i=0;i<50;i++){
            if(user1==a.arr[i].user1 && amount==a.arr[i].Amount){
                transaction refund1=new refund(amount,user1);
                for(int j=0;j<50;j++){
                    if(a.arr[j].transactiontype==" "){
                        a.arr[j]=refund1;
                        break;
                    }
                }
                break;
            }
        }
    }

    public String addspaificdiscount( int password,String service,double percent){
    	if(check(password)) {
                Discount d1=new spacific(service,percent);
                for(int i=0;i<50;i++){
                    if(a.d[i]==null){
                        a.d[i]=d1;
                        return "spacific discount added";
                }
            }
        }
        return "wrong admin password"; 
    }

    public String addovaralldiscount(int password,double percent) {
    	if(check(password)) {
    		Discount d1=new ovarall(percent);
            for(int i=0;i<50;i++){
                if(a.d[i]==null){
                    a.d[i]=d1;
                    return "ovarall discount added";
    	        }
            }
        }
        return "wrong admin password"; 
    }
    
    public String checkdiscounts() {
    	String out="";
    	for(int i=0;i<50;i++) {
    		if(a.d[i]==null) {
    			break;
    		}
    		else {
    			out+=a.d[i].name+"    "+a.d[i].percent+"\n";
    		}
    			
    	}
    	return out;
    }
}
