package com.sarthak.inventorymgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableTransactionManagement
@Slf4j
public class InventorymgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorymgmtApplication.class, args);
		log.info("Inventory Management Application Started @" + System.getProperty("server.port"));
	}

}
