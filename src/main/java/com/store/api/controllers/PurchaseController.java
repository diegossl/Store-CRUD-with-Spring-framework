package com.store.api.controllers;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.api.config.MailConfig;
import com.store.api.models.Purchase;
import com.store.api.services.MailService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	private MailConfig mailConfig;
	
	@Autowired
	@PostMapping("/sendPurchaseOrder")
	public ResponseEntity<String> sendEmail(@RequestBody Purchase purchase) {
		try {
			//MailService mailService = new MailService(purchase);
			//mailService.sendMessage();
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("elasmaquiagem@gmail.com");
	        mailSender.setPassword("teste123maquiagem");
	        
	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");

	        // Create an email instance
	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        mailMessage.setFrom(purchase.getEmail());
	        mailMessage.setTo(purchase.getEmail());
	        mailMessage.setSubject("Novo e-mail de " + purchase.getName());
	        mailMessage.setText("Enviooooooooooouuuu");
	        mailSender.send(mailMessage);
	        
	        
			return new ResponseEntity<>("Email enviado com sucesso.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
