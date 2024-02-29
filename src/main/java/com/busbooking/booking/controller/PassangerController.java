package com.busbooking.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.busbooking.booking.model.Passanger;
import com.busbooking.booking.service.PassangerService;

@RestController("/busbooking/passanger")
public class PassangerController
{

	@Autowired
	private PassangerService passangerService;
	
	@GetMapping("/getAllPassanger")
	public List<Passanger> getAllPassanger()
	{
		return passangerService.getAllPassanger();
	}
	
	@GetMapping("/getPassangerById/{passangerId}")
	public Passanger getPassangerById(
			@PathVariable long passangerId)
	{
		return passangerService.getPassangerById(passangerId);
	}
	
	@PostMapping("/addPassanger")
	public Passanger addPassanger(
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam Integer age,
			@RequestParam String gender)
	{
		return passangerService.addPassanger(firstName,lastName,age,gender);
	}
	
	@PostMapping("/updatePassanger/{passangerId}")
	public Passanger updatePassanger(
			@PathVariable long passangerId,
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam Integer age,
			@RequestParam String gender)
	{
		return passangerService.updatePassanger(passangerId,firstName,lastName,age,gender);
	}
	
	@DeleteMapping("/deletePassanger/{passangerId}")
	public void deletePassanger(
			@PathVariable long passangerId )
	{
		passangerService.deletePassangerById(passangerId);
	}
}
