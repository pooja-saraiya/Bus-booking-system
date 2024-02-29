package com.busbooking.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busbooking.booking.model.Passanger;
import com.busbooking.booking.repository.PassangerRepository;

@Service
public class PassangerService 
{
	@Autowired
	private PassangerRepository passangerRepository;

	public List<Passanger> getAllPassanger()
	{
		return passangerRepository.findAll();
	}

	public void deletePassangerById(long passangerId) 
	{
		passangerRepository.deleteById(passangerId);
	}

	public Passanger getPassangerById(long passangerId) 
	{
		return passangerRepository.findById(passangerId).orElseThrow();
	}

	public Passanger addPassanger(String firstName, String lastName, Integer age, String gender) 
	{
		Passanger passanger = new Passanger();
		passanger.setFirstName(firstName);
		passanger.setLastName(lastName);
		passanger.setAge(age);
		passanger.setGender(gender);
		return passangerRepository.save(passanger);
	}

	public Passanger updatePassanger(long passangerId, String firstName, String lastName, Integer age, String gender) {
		try
		{
			Passanger passanger = getPassangerById(passangerId);
			
			if(firstName != null && !firstName.isEmpty())
				passanger.setFirstName(firstName);
			
			if(lastName != null && !lastName.isEmpty())
				passanger.setLastName(lastName);
			
			if(gender != null && !lastName.isEmpty())
				passanger.setGender(gender);
			
			if(age != null && age>0)
				passanger.setAge(age);
			
			return passangerRepository.save(passanger);
		}
		catch(Exception e)
		{
			return new Passanger();
		}
	}
	
	
}
