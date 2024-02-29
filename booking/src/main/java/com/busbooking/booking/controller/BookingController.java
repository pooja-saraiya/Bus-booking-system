package com.busbooking.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import com.busbooking.booking.BookingProducer;
import com.busbooking.booking.model.Booking;
import com.busbooking.booking.model.RouteView;
import com.busbooking.booking.service.BookingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController("/busbooking/booking")
public class BookingController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
	@Autowired
	private BookingService bookingService;
	
	private BookingProducer bookingProduser;
	
	public BookingController(BookingProducer bookingProduser)
	{
		this.bookingProduser = bookingProduser;
	}
	 
	@PostMapping("/addBooking")
	public String addBooking(@RequestParam long busId,
			@RequestParam int noOfTickets,
			@RequestParam long routeId,
			@RequestParam long passangerId) throws JsonProcessingException
	{
		HashMap<String, Long> params = new HashMap<>(); 
		params.put("busId", busId); 
		
		ResponseEntity<Integer> availableSeats = new RestTemplate().getForEntity(
				"http://localhost:8087/busbooking/businformation/getAvailableSeatInBus/{busId}"  ,
				Integer.class,params);
		
		Integer availableSeatToBook = availableSeats.getBody();
		System.out.println("availableSeatToBook" +availableSeatToBook);
		
		if(availableSeatToBook > 0 && availableSeatToBook >= noOfTickets)
		{
			params = new HashMap<>(); 
			params.put("routeId", routeId); 
			ResponseEntity<RouteView> routeView = new RestTemplate().getForEntity(
					"http://localhost:8088//getRouteById/{routeId}" ,
					RouteView.class,params);
			
			int totalAmt = routeView.getBody().getPrice()*noOfTickets;
			Booking booking = new Booking();
			booking.setBusId(busId);
			booking.setRouteId(routeId);
			booking.setBookingConfirmationStatus("Pending");
			booking.setPassangerId(passangerId);
			booking.setBookingAmount(totalAmt);
			booking.setNoOfSeatsBooked(noOfTickets);
			
			ObjectMapper mapper = new ObjectMapper();
			booking = bookingService.addBooking(booking);
			
			Map<String,Object> msg = new HashMap<String,Object>();
			msg.put("status", "PENDING");
			msg.put("id", booking.getBookingRefrenceNo());
			msg.put("noOfTickets", noOfTickets);
			msg.put("routeId", routeId);
			msg.put("busId", busId);
			LOGGER.info("BookingController : add booking :: msg {} {} ",mapper.writeValueAsString(msg), msg.size());
			bookingProduser.sendMessage(msg);
			
			return "Ticket is booked with refrence no: "+booking.getBookingRefrenceNo()+"please prooceed with payment";
		}
		else
		{
			return "Not enough seats to book in the Bus";
		}
	}
	
	@GetMapping("/viewBooking")
	public List<Booking> viewBooking()
	{
		return bookingService.viewBooking();
	}
	
	@GetMapping("/viewBookingById/{bookingRefrenceNo}")
	public Booking viewBookingById(
			@PathVariable Long bookingRefrenceNo)
	{
		return bookingService.viewBookingById(bookingRefrenceNo);
	}
	
	@PostMapping("/cancleBooking")
	public String cancleBookingById(
			@PathVariable Long bookingRefrenceNo)
	
	{
		try
		{
			Booking booking = bookingService.viewBookingById(bookingRefrenceNo);
			LOGGER.error("booking {} ",booking.getBookingRefrenceNo());
			Integer noOfSeatToCancle = booking.getNoOfSeatsBooked();
			LOGGER.error("noOfSeatToCancle {} ",noOfSeatToCancle);
			Long busId = booking.getBusId();
			LOGGER.error("busId {} ",busId);
			
			HashMap<String, Long> params = new HashMap<>(); 
			params.put("busId", busId); 
			params.put("noOfSeatToCancle", Long.parseLong(noOfSeatToCancle.toString()));
			
			new RestTemplate().getForEntity(
					"http://localhost:8087/busbooking/businformation/cancelSeatInBus/{busId}/{noOfSeatToCancle}"  ,
					String.class,params);
			
			LOGGER.error("updated bus{} ");
			Long paymentId = booking.getPaymentId();
			params = new HashMap<>(); 
			params.put("paymentId", paymentId); 
			
			new RestTemplate().getForEntity(
					"http://localhost:8090/busbooking/busPayment/canclePayment/{paymentId}"  ,
					String.class,params);
			
			LOGGER.error("deleted payment {} ",busId);
			bookingService.deleteBookingById(bookingRefrenceNo);
			
			
			
			return "Booking cancle successfully";
		}
		catch(Exception e)
		{
			LOGGER.error("error"+e.getMessage());
			return "can not cancle booking "+e.getMessage();
		}
	}
}
