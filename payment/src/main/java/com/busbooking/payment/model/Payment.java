package com.busbooking.payment.model;

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
@Table(name ="payment")
public class Payment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Long paymentId;
	
	@Column(name = "bubooking_refrence_nos_id", nullable = false)
    private Long bookingRefrenceNo;
	
	@Column(name = "payment_date_time", nullable = false)
    private Long paymentDateTime;
	
	@Column(name = "payment_mode", nullable = true)
    private String paymentMode;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getBookingRefrenceNo() {
		return bookingRefrenceNo;
	}

	public void setBookingRefrenceNo(Long bookingRefrenceNo) {
		this.bookingRefrenceNo = bookingRefrenceNo;
	}

	public Long getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(Long paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
}
