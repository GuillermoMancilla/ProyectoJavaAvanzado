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
			Category category1 = new Category("Tecnología", "Productos electrónicos y computación");
			Category category2 = new Category("Hogar", "Artículos para el hogar y decoración");
			Category category3 = new Category("Indumentaria", "Ropa y accesorios");

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

//Se comenta ya que los productos seran creados desde peticion
//			Product product1 = new Product("Laptop Lenovo", "Notebook 15 pulgadas", 850.0);
//			Product product2 = new Product("Mouse Logitech", "Mouse inalámbrico", 25.5);
//			Product product3 = new Product("Monitor Samsung", "Monitor 24 pulgadas", 199.99);
//			Product product4 = new Product("Repisa x1", "Repisa para libros", 30.99);
//			Product product5 = new Product("Polera", "polera variedad color", 10.99);
//			productRepository.save(product1);
//			productRepository.save(product2);
//			productRepository.save(product3);
//			productRepository.save(product4);
//			productRepository.save(product5);

		};
	}

}
