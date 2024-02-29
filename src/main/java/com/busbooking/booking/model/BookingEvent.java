package com.busbooking.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingEvent
{
	 private String message;
	 private String status;
	 private Booking booking;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
