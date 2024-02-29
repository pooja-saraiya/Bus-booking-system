package com.busbooking.payment;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.busbooking.payment.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentConsumer
{
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentConsumer.class);

	@Value("${spring.kafka.topic.name}")
	private  String  topic;
	
	@Value("${spring.kafka.consumer.group-id}")
	private String group;
	@Autowired
	private PaymentService paymentService;
	
    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}" )
    public void consume( Map<String,Object> event)
    {
    	try
    	{
    		ObjectMapper mapper = new ObjectMapper();
    		LOGGER.info("PaymentConsumer : consume :: {}", mapper.writeValueAsString(event));
    		paymentService.processPayment(event);
        }
    	catch(Exception e)
    	{
    		LOGGER.error("PaymentConsumer : consume :: Exception {} ", e.getMessage());

    	}
    }
}
