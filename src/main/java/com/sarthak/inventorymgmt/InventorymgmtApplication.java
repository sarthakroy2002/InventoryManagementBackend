package com.sarthak.inventorymgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class InventorymgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorymgmtApplication.class, args);
	}

}
