package com.busbooking.payment.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class BookingDTO
{
	
    private Long bookingRefrenceNo;
	
    private Long busId;
	
    private Long routeId;
	
    private Long passangerId;

    private Long paymentId;
    private Integer noOfSeatsBooked;
	
    private Integer bookingAmount;
	
    private  String bookingConfirmationStatus;
	

	public Long getBookingRefrenceNo() {
		return bookingRefrenceNo;
	}

	public void setBookingRefrenceNo(Long bookingRefrenceNo) {
		this.bookingRefrenceNo = bookingRefrenceNo;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Long getPassangerId() {
		return passangerId;
	}

	public void setPassangerId(Long passangerId) {
		this.passangerId = passangerId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getNoOfSeatsBooked() {
		return noOfSeatsBooked;
	}

	public void setNoOfSeatsBooked(Integer noOfSeatsBooked) {
		this.noOfSeatsBooked = noOfSeatsBooked;
	}

	public Integer getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(Integer bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public String getBookingConfirmationStatus() {
		return bookingConfirmationStatus;
	}

	public void setBookingConfirmationStatus(String bookingConfirmationStatus) {
		this.bookingConfirmationStatus = bookingConfirmationStatus;
	}

	
	
	
	
}
