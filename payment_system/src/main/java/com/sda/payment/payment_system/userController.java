package com.sda.payment.payment_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    public static user[] arr;
    public user useron;
    public adminController admin;

    public userController() {
    	admin=new adminController();
    	useron=new user();
    	arr=new user[50];
        for(int i=0;i<50;i++) {
        	arr[i]=new user();
        }
    }

    public boolean check(String Email,String username) {
        for (int i = 0; i < 50; i++) {
            if (arr[i].Email == Email && arr[i].username == username) {
                return true;
            }
        }
        return false;
    }
    
    @GetMapping("/signin/{Email}/{Password}")
    public String signIn(@PathVariable String Email,@PathVariable String Password) {
        for (int i = 0; i < 50; i++)
            if (Email == arr[i].Email && Password == arr[i].Password) {
            	useron=arr[i];
                return "signed in successfully";
            }
        return "user does not exist";
    }
    
    
    //works
    @PostMapping("/signup/{username}/{Email}/{Password}")
    public String signUp(@PathVariable String username,@PathVariable String Email,@PathVariable String Password) {
        if (check(Email,username))  {
        	return "user already registered";
        }
        else {
            for (int i = 0; i < 50; i++) {
                if (arr[i].username == " ") {
                	user u=new user(username,Email,Password);
                    arr[i]=u;
                    useron=u;
                    return "user registered successfully";
                }
            }
        }
        return " ";
    }
    
    //works
    @PutMapping("/addtowallet/{amount}")
    public String addtowallet(@PathVariable double amount) {
        useron.wallet+=amount;
        transaction pay1=new addtowallet(amount,useron);
        admin.add(pay1);
        return "amount successfully added to wallet\namount of money on the wallet = "+useron.wallet;
    }

    @PostMapping("/payment/{i}")
    public void payment(@PathVariable String i) {
        switch (i) {
            case "mobile":
                serviceForm form1 = new mobileform();
                form1.showform(useron, admin);
                break;
            case "internet":
                serviceForm form2 = new internetform();
                form2.showform(useron, admin);
                break;
            case "landline":
                serviceForm form3 = new landlineform();
                form3.showform(useron, admin);
                break;
            case "donations":
                serviceForm form4 = new donationform();
                form4.showform(useron, admin);
                break;
        }
    }

    //works
    @GetMapping("/search/{str}")
    public String search(@PathVariable String str) {
        switch (str) {
            case "mobile":
                return "mobile recharge services";
            case "internet":
                return "internet payment services";
            case "landline":
                return "landline services";
            case "donations":
                return "donations";
            default:
                return "service does not exist";
        }
    }

    //works
    @PostMapping("/refundrequest/{amount}")
    public String refundrequest(@PathVariable double amount){
        admin.refund(useron,amount);
        return "refund requested";
    }

    //works
    @GetMapping("/checkdiscounts")
    public String checkdiscounts() {
    	String out=admin.checkdiscounts();
    	return out;
    }
    
    @PutMapping("/approve/{password}")
    public void approve(@PathVariable int password){
        admin.approve();
    }

    //works
    @GetMapping("/list/{password}")
    public String list(@PathVariable int password){
    	String out=admin.list();
        return out;
    }

    //works
    @PostMapping("/addspaificdiscount/{password}/{service}/{percent}")
    public String addspaificdiscount(@PathVariable int password,@PathVariable String service,@PathVariable double percent){
    	String out=admin.addspaificdiscount(password, service, percent);
        return out;
    }

    //works
    @PostMapping("/addovaralldiscount/{password}/{percent}")
    public String addovaralldiscount(@PathVariable int password,@PathVariable double percent) {
    	String out=admin.addovaralldiscount(password, percent);
        return out;
    	}
};
