package com.store.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {

	@Autowired
	
	private JavaMailSender emailSender;

	public void sendMessage(String from, String subject, String text) {
	    SimpleMailMessage message = new SimpleMailMessage(); 
	    message.setFrom(from);
	    message.setSubject(subject); 
	    message.setText(text);
	    emailSender.send(message);
	}

}
