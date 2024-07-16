package com.sda.payment.payment_system;

import org.springframework.stereotype.Component;

@Component
public class user {
      public String username;
      public String Email;
      public String Password;
      public double wallet;

    public user() {
        // TODO Auto-generated constructor stub
        username=" ";
        Email=" ";
        Password=" ";
        wallet=0;
    }
      public user(String u,String e,String p) {
          // TODO Auto-generated constructor stub
          username=u;
          Email=e;
          Password=p;
          wallet=0;
      }

      public void setInfo(String u,String e,String p)
      {
          username=u;
          Email=e;
          Password=p;
      }

  }


