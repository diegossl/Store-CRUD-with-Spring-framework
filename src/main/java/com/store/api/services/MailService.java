package com.store.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.store.api.config.MailConfig;
import com.store.api.models.Purchase;

@Component
public class MailService {

	@Autowired
	private JavaMailSender emailSender;
	
	private MailConfig mailConfig;
	private Purchase purchase;
	
	public MailService(Purchase purchase) {
		this.purchase = purchase;
	}

	public void sendMessage() {
	    /*SimpleMailMessage message = new SimpleMailMessage();
	    message.setFrom(purchase.getEmail());
	    message.setSubject(purchase.getName()); 
	    message.setText("Enviooooooooooouuuu");
	    emailSender.send(message);*/
		
        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.mailConfig.getHost());
        mailSender.setPort(this.mailConfig.getPort());
        mailSender.setUsername(this.mailConfig.getUsername());
        mailSender.setPassword(this.mailConfig.getPassword());

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(purchase.getEmail());
        //mailMessage.setTo("rc@feedback.com");
        mailMessage.setSubject("Novo e-mail de " + purchase.getName());
        mailMessage.setText("Enviooooooooooouuuu");

        // Send mail
        mailSender.send(mailMessage);
	}

}
