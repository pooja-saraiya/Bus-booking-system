package com.busbooking.payment.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busbooking.payment.BookingStatusProducer;
import com.busbooking.payment.PaymentProducer;
import com.busbooking.payment.model.Payment;

@Service
public class PaymentService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	private PaymentRepository paymentRepository;
	
	private PaymentProducer paymentProducer;
	
	private BookingStatusProducer bookingStatusProducer;
	
	public PaymentService(PaymentProducer paymentProducer, BookingStatusProducer bookingStatusProducer)
	{
		this.paymentProducer = paymentProducer;
		this.bookingStatusProducer = bookingStatusProducer;
	}
	public Payment processPayment(Map<String,Object> event) throws Exception
	{
		try
		{
			Payment pay = new Payment();
			pay.setBookingRefrenceNo(Long.parseLong(String.valueOf(event.get("id"))));
			pay.setPaymentDateTime(System.currentTimeMillis());
			pay.setPaymentMode("Online");
			pay = paymentRepository.save(pay);
			LOGGER.info("sending msg to inventory ");
			event.put("paymentRefrenceNO", pay.getPaymentId());
			paymentProducer.sendMessage(event);
			LOGGER.info("sent msg to inventory ");
			return pay;
		}
		catch(Exception e)
		{
			LOGGER.error("Payment failed cancelling booking... ");
			event.put("status", "Failed");
			bookingStatusProducer.sendMessage(event);
			LOGGER.error("Payment failed cancel booking msg send ");
			throw new Exception("Revert the transection");
		}

	}
	public void canclePayment(Long paymentId) 
	{
		paymentRepository.deleteById(paymentId);
	}
}
