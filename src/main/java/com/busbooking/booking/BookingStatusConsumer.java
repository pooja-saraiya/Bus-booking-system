package com.busbooking.booking;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.busbooking.booking.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookingStatusConsumer 
{
	@Autowired
	private BookingService bookingService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingStatusConsumer.class);
	@KafkaListener(topics ="${spring.kafka.topic.name.inventory}" ,
			groupId = "${spring.kafka.consumer.group-id.inventory}" )
    public void consume( Map<String,Object> event)
    {
    	try
    	{
    		ObjectMapper mapper = new ObjectMapper();
    		LOGGER.info("BookingStatusConsumer : consume :: {}", mapper.writeValueAsString(event));
    		bookingService.updateBookingSratus(event);
        }
    	catch(Exception e)
    	{
    		LOGGER.error("PaymentConsumer : consume :: Exception {} ", e.getMessage());

    	}
    }
}
