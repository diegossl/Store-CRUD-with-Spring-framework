package com.store.api.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.api.models.Product;
import com.store.api.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/list")
	public ResponseEntity<List<Product>> index() {
		try {
			List<Product> productList = productRepository.findAll();
			if(!productList.isEmpty()) {
				return new ResponseEntity<>(productList, HttpStatus.OK);
			}
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable("productId") String productId) {
		try {
			Optional<Product> product = productRepository.findById(productId);
			if(product.isPresent()) {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<String> store(@RequestBody List<Product> products) {
		try {
			this.productRepository.saveAll(products);
			return new ResponseEntity<>("Produto cadastro com sucesso.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possível cadastrar o produto.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping("/update/{productId}")
	public ResponseEntity<String> update(@PathVariable("productId") String productId, @RequestBody Product product) {
		try {
			Optional<Product> oldProduct = this.productRepository.findById(productId);
			if(oldProduct.isPresent()) {
				Product newProduct = oldProduct.get();
				newProduct.setName(product.getName());
				newProduct.setDescription(product.getDescription());
				this.productRepository.save(newProduct);
				return new ResponseEntity<>("Produto atualizado com sucesso.", HttpStatus.OK);
			}
			return new ResponseEntity<>("Produto não encontrado.", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possível atualizar o produto.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<String> delete(@PathVariable("productId") String productId) {
		try {
			this.productRepository.deleteById(productId);
			return new ResponseEntity<>("Produto apagado com sucesso.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Produto não pode ser deletado.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}