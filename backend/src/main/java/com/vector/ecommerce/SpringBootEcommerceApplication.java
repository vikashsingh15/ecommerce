package com.vector.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vector.ecommerce.dao.ProductRepository;

@SpringBootApplication
public class SpringBootEcommerceApplication {

	public static void main(String[] args) {

		ApplicationContext  context = SpringApplication.run(SpringBootEcommerceApplication.class, args);
		ProductRepository productRepository= context.getBean(ProductRepository.class);
		System.out.println(productRepository.findAll());
	}

}
