package com.store.api.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.api.models.Product;
import com.store.api.models.Purchase;
import com.store.api.repositories.ProductRepository;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private ProductRepository productRepository;

	
	@PostMapping("/sendPurchaseOrder")
	public ResponseEntity<String> sendEmail(@RequestBody Purchase purchase) {
		try {
	    	SimpleMailMessage message = new SimpleMailMessage();
	    	String text = this.formatEmail(purchase.getProductId());
	        message.setTo("dlecomp20@gmail.com");
	        message.setSubject("Pedido de compra de " + purchase.getName());
	        message.setText(text);
            mailSender.send(message);
			return new ResponseEntity<>("Email enviado com sucesso.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private String formatEmail(String id) {
		Optional<Product> productFound = productRepository.findById(id);
		if(productFound.isPresent()) {
			Product product = productFound.get();
			String text = "Produto: " + product.getName() + "\n" +
					"Descrição: " + product.getDescription();
			return text;
		}
		return "Compra inválida! O produto não foi encontrado na base de dados.";
	}
}
