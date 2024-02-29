package com.busbooking.payment.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busbooking.payment.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>
{

}
