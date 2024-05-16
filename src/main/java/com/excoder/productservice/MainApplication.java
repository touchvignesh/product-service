package com.excoder.productservice;


import com.excoder.productservice.model.Product;
import com.excoder.productservice.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class MainApplication {

	private static final Logger log = LoggerFactory.getLogger(MainApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Autowired
	ProductRepository ProductRepository;

	// Run this if app.db.init.enabled = true
	@Bean
	@ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
	public CommandLineRunner demoCommandLineRunner() {
		return args -> {

			System.out.println("Running.....");

			Product p1 = new Product(1, "iPhone 11", "Silver" ,
					BigDecimal.valueOf(39999.00),
					LocalDate.of(2023, 8, 31));
			Product p2 = new Product(2, "iPhone 12", "Gold" ,
					BigDecimal.valueOf(49999.00),
					LocalDate.of(2023, 10, 31));
			Product p3 = new Product(3, "iPhone 13", "Midnight Black" ,
					BigDecimal.valueOf(59999.00),
					LocalDate.of(2023, 12, 31));
			Product p4 = new Product(4, "iPhone 14", "Rose Gold" ,
					BigDecimal.valueOf(69999.00),
					LocalDate.of(2024, 05, 30));

			ProductRepository.saveAll(List.of(p1, p2, p3, p4));

		};
	}
}
