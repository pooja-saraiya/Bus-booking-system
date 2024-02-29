package com.busbooking.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/busbooking/busPayment")
public class PaymentController
{
	@Autowired
	PaymentService paymentService;
	
	
	@DeleteMapping("/canclePayment/{paymentId}")
	public String canclePayment(
			@PathVariable Long paymentId)
	{
		paymentService.canclePayment(paymentId);
		return "Payment deleted successfully";
	}
}
