package com.store.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.api.models.Purchase;
import com.store.api.services.MailService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	
	@PostMapping("/sendPurchaseOrder")
	public ResponseEntity<String> sendEmail(@RequestBody Purchase user) {
		try {
			MailService mailService = new MailService();
			mailService.sendMessage("test@gmail.com", "Test", "bla bla bla");
			return new ResponseEntity<>("Email enviado com sucesso.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
