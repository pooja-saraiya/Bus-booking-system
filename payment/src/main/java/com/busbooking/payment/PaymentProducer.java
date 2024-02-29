package com.busbooking.payment;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentProducer.class);
	
	@Value("${spring.kafka.topic.name.inventory}")
	private  String  topic;

    @Autowired
    private KafkaTemplate<String, Map<String, Object>> kafkaTemplate;

    public void sendMessage(Map<String, Object> message)
    {
        kafkaTemplate.send(topic, message);
        LOGGER.info("Message sent: " + message);
    }
}
