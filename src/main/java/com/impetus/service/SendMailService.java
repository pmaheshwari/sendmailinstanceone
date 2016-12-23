package com.impetus.service;

import org.springframework.stereotype.Service;

import com.impetus.model.MetroDetail;

@Service
public class SendMailService {
	
	public String formEmailContent(MetroDetail data) {
		return "The fare from station " + data.getSource()
				+ " to station " + data.getDestination() + " is Rs. "
				+ data.getFare();
	}

}
