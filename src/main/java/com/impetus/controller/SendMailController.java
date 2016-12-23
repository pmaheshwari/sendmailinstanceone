package com.impetus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.EmailInfo;
import com.impetus.service.SendMailProducer;
import com.impetus.service.SendMailService;

@RestController
public class SendMailController {

	@Autowired
	private SendMailProducer sendMailProducer;
	
	@Autowired
	private SendMailService sendMailService;

	private static final Logger log = LoggerFactory.getLogger(SendMailController.class);
	
	@RequestMapping(value = "/mail")
	public @ResponseBody void serviceInstanceMail(
			@RequestBody EmailInfo emailInfo) {
		log.info("--Putting the message to Kafka--");
		sendMailProducer.putMessageToKafaka("topic", emailInfo.getEmailId(),
				sendMailService.formEmailContent(emailInfo.getData()));
	}
}