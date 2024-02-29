package com.busbooking.booking.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busbooking.booking.model.Booking;
import com.busbooking.booking.repository.BookingRepository;

@Service
public class BookingService 
{
	@Autowired
	private BookingRepository bookingRepository;

	public Booking addBooking(Booking booking)
	{
		return bookingRepository.save(booking);
	}

	public void updateBookingSratus(Map<String, Object> event) 
	{
	
		Long id = Long.parseLong(String.valueOf(event.get("id")));
		
		Optional<Booking> bookingOptinal = bookingRepository.findById(id);
		
		if(bookingOptinal.isPresent())
		{
			Booking booking = bookingOptinal.get();
			String status = event.get("status").toString();
			
			if(event.get("paymentRefrenceNO") != null)
			{
				Long paymentNo = Long.parseLong(event.get("paymentRefrenceNO").toString());
				booking.setPaymentId(paymentNo);
			}
			booking.setBookingConfirmationStatus(status);
			bookingRepository.save(booking);
		}
		
	}

	public List<Booking> viewBooking()
	{
		return bookingRepository.findAll();
	}

	public Booking viewBookingById(Long bookingRefrenceNo)
	{
		return bookingRepository.findById(bookingRefrenceNo).orElse(new Booking());
	}

	public void deleteBookingById(Long bookingRefrenceNo)
	{
		bookingRepository.deleteById(bookingRefrenceNo);
		
	}
}
