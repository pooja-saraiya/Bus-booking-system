package com.busbooking.booking;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingProducer 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingProducer.class);
	
	@Value("${spring.kafka.topic.name}")
	private  String  topic;

    @Autowired
    private KafkaTemplate<String, Map<String, Object>> kafkaTemplate;

    public void sendMessage(Map<String, Object> message)
    {
        kafkaTemplate.send(topic, message);
        LOGGER.info("Message sent: " + message);
    }
}
