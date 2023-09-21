package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public static class Product{
		private String name ;
		private int price;
		private int discount;

		public Product(String name, int price, int discount) {
			this.name = name;
			this.price = price;
			this.discount = discount;
		}

		public String getName() {
			return name;
		}

		public int getPrice() {
			return price;
		}

		public int getDiscount() {
			return discount;
		}
	}

	public static class Discounted_price{
		private String name;
		private int discounted_price;

		public Discounted_price(String name, int discounted_price) {
			this.name = name;
			this.discounted_price = discounted_price;
		}

		public String getName() {
			return name;
		}

		public int getDiscounted_price() {
			return discounted_price;
		}
	}

	@PostMapping("/product")
	public ResponseEntity createProduct(@RequestBody Product product){
		return new ResponseEntity(
				new Discounted_price(product.getName(),
						product.getPrice() - product.getPrice() * product.getDiscount() / 100),
				HttpStatus.OK);

	}
}
