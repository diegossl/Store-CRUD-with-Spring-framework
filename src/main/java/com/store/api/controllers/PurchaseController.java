package com.store.api.controllers;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.api.models.Purchase;
import com.store.api.models.PurchaseData;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@PostMapping("/sendPurchaseOrder")
	public ResponseEntity<String> sendEmail(@RequestBody Purchase purchase) {
		try {
	    	SimpleMailMessage message = new SimpleMailMessage();
	    	String text = this.purchaseResponse(purchase);
	        message.setTo("dlecomp20@gmail.com");
	        message.setSubject("Pedido de compra de " + purchase.getBuyerName());
	        message.setText(text);
            mailSender.send(message);
			return new ResponseEntity<>("Email enviado com sucesso.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Falha ao tentar enviar o email.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private String purchaseResponse(Purchase purchase) {
		ArrayList<PurchaseData> listOfPurchasedProducts = purchase.getProductList();
		String buyerName = purchase.getBuyerName();
		String buyerPhone = purchase.getBuyerPhone();
						
		if (!listOfPurchasedProducts.isEmpty()) {
			String productListText = "";
			for(PurchaseData product : listOfPurchasedProducts) {
				productListText +=
					"\n\n" +
					"Nome: " + product.getName() + "\n" +
					"Descrição: " + product.getDescription() + "\n" +
					"Preço: " + product.getPrice() + "\n" +
					"Quantidade comprada: " + product.getQuantityPurchased() + "\n";
			}
			
			String text =
				"COMPRADOR(A): " + buyerName + "\n" +
				"CELULAR: " + buyerPhone + "\n\n" +
				"LISTA DE PRODUTOS" +
				productListText;
		
			return text;
		}
		return "Compra inválida! O produto não foi encontrado na base de dados.";
	}
}
