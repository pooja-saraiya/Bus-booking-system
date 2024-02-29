package com.busbooking.payment.Exception;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class SeekToCurrentErrorHandler implements ErrorHandler {

	@Override
	public void handle(Exception thrownException, ConsumerRecord<?, ?> data) 
	{
		System.out.println("SeekToCurrentErrorHandler : Exception ");
	}

}
