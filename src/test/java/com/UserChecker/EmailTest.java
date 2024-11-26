package com.UserChecker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.UserChecker.Service.EmailService;

@SpringBootTest
public class EmailTest {
	
	@Autowired
	private EmailService emailService;

	@Test
	void emailSendTest() {
		emailService.sendEmail("sahildagar3390@gmail.com", "Test sending function", "<h1>hellow bro</h1>");
		emailService.sendEmailHtmlContent("sahildagar3390@gmail.com", "Test sending function", "<h1>hellow bro</h1>");
		System.out.print("send email");
	}
}
