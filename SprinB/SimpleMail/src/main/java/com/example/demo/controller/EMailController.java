package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EMailController {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@GetMapping(value="/sending")
	public String sendEmail()
	{
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		//used for simple text mail
		
		mailMessage.setTo("divekar.anuja27@gmail.com");
		mailMessage.setSubject("mail sending code");
		mailMessage.setText("for education purpose");
		
		javaMailSender.send(mailMessage);
		
		return "send mail successfully";
		
	}
}
