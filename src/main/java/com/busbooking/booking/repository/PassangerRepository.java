package com.busbooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busbooking.booking.model.Passanger;

@Repository
public interface PassangerRepository extends JpaRepository<Passanger, Long>
{

}
