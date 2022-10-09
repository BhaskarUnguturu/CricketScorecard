package com.cgi.cmatch.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.cgi.cmatch.exception.MailSendingException;

@Component
public class SimpleMailer {

	@Autowired
	private JavaMailSender javaMailSender;

	public SimpleMailer() {
		super();
	}

	@Autowired
	public SimpleMailer(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}

	public void send(String to, String subject, String body) throws MailSendingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body, true);
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailSendingException("Mail Cannot be Sent");
		}

	}

}