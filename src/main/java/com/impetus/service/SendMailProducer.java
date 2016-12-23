package com.impetus.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SendMailProducer {
	
	private  Producer<String, String> producer = null;
	private static final Logger log = LoggerFactory.getLogger(SendMailProducer.class);
	
	public SendMailProducer(){

	    Properties props = new Properties();
	    props.put("bootstrap.servers", "localhost:9092");
	    props.put("acks", "all");
	    // If request fails, then automatically retry with specific value.
	    props.put("retries", 0);
	    props.put("batch.size", 16384);
	    props.put("linger.ms", 1);
	    // total amount of memory available to the producer for buffering.
	    props.put("buffer.memory", 33554432);
	    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	    producer = new KafkaProducer<>(props);
	    log.info("--Initialized Producer--");
	}
	
	public void putMessageToKafaka(String topicName, String key, String value)
	{
		producer.send(new ProducerRecord(topicName, key, value));
		log.info("--Record sent--");
	}
}
