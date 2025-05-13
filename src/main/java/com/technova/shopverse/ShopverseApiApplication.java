package com.technova.shopverse;

import com.technova.shopverse.model.Category;
import com.technova.shopverse.model.Product;
import com.technova.shopverse.repository.CategoryRepository;
import com.technova.shopverse.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopverseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopverseApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(CategoryRepository categoryRepository, ProductRepository productRepository){
		return args -> {
			categoryRepository.save(new Category("Tecnología", "Productos electrónicos y computación"));
			categoryRepository.save(new Category("Hogar", "Artículos para el hogar y decoración"));
			categoryRepository.save(new Category("Indumentaria", "Ropa y accesorios"));
			productRepository.save(new Product("Laptop Lenovo", "Notebook 15 pulgadas", 850.0));
			productRepository.save(new Product("Mouse Logitech", "Mouse inalámbrico", 25.5));
			productRepository.save(new Product("Monitor Samsung", "Monitor 24 pulgadas", 199.99));
		};
	}

}
