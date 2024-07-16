package com.sda.payment.payment_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sda.payment.payment_system")
public class PaymentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentSystemApplication.class, args);
	}

}
