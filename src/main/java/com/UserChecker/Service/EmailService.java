package com.UserChecker.Service;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import  org.slf4j.Logger;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private Logger logger=LoggerFactory.getLogger(EmailService.class);
//
	@Value("${sender.emailid}")
	private String sendBy;
	
	public void sendEmail(String to,String subject,String meassage) {
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(meassage);
		simpleMailMessage.setFrom(sendBy);
		
		javaMailSender.send(simpleMailMessage);
		
		logger.info("Email has been sent");
	}
	
	public void sendEmailHtmlContent(String to,String subject,String meassage) {
		
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		
			try {
				MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true,"UTF-8");
				
				mimeMessageHelper.setTo(to);
				mimeMessageHelper.setSubject(subject);
				mimeMessageHelper.setText(meassage,true);
				mimeMessageHelper.setFrom(sendBy);
				
				javaMailSender.send(mimeMessage);
				
				logger.info("Email has been sent");
			} catch (MessagingException e) {
				e.printStackTrace();
				throw new RuntimeException("not able to send email");
			}
	}
}
