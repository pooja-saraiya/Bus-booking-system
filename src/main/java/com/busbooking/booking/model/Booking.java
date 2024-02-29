package com.busbooking.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="bus_booking")
public class Booking 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "booking_refrence_no", nullable = false)
    private Long bookingRefrenceNo;
	
	@Column(name = "bus_id", nullable = false)
    private Long busId;
	
	@Column(name = "route_id", nullable = false)
    private Long routeId;
	
	@Column(name = "passanger_id", nullable = false)
    private Long passangerId;
	
	@Column(name = "payment_id", nullable = true)
    private Long paymentId;
	
	@Column(name = "no_of_seats_booked", nullable = false)
    private Integer noOfSeatsBooked;
	
	@Column(name = "booking_amount", nullable = false)
    private Integer bookingAmount;
	
	@Column(name = "booking_confirmation_status", nullable = false)
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
