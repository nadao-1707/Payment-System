package com.sda.payment.payment_system;

public class spacific extends Discount{
	public String service;
    public spacific(String service, double percent) {
            this.service=service;
            this.percent=percent;
            name="sapcific discount";
        }

    public spacific() {
		
	}

	@Override
    public void Transaction() {

    }
}

