package com.busbooking.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.busbooking.admin.model.RouteInfo;
import com.busbooking.admin.service.RouteService;

@RestController("busbooking/route")
public class RouteController 
{
	@Autowired
	private RouteService routeService;
	
	@GetMapping("/getAllBusRoutes")
	public List<RouteInfo> getAllBusRoutes()
	{
		return routeService.getAllBusRoutes();
	}
	
	@GetMapping("/getBusRouteById/{busId}")
	public RouteInfo getBusbyId(
			@PathVariable long busId)
	{
		return routeService.getBusRouteById(busId).get(0);
	}
	
	@GetMapping("/getRouteById/{routeId}")
	public ResponseEntity<Object> getRouteById(
			@PathVariable long routeId)
	{
		try
		{
			RouteInfo routeInfo = routeService.getRouteById(routeId);
			return ResponseEntity.ok().body(routeInfo);
		}
		
		catch(Exception e)
		{
			return ResponseEntity.ok().body("No route found with given id");
		}
	}
	
	@PostMapping("/addBusRoute")
	public RouteInfo addBusRoute(
			@RequestParam Long busId,
			@RequestParam String source,
			@RequestParam String destination,
			@RequestParam Integer price)
	{
		RouteInfo routeInfo = new RouteInfo();
		routeInfo.setBusId(busId);
		routeInfo.setDestination(destination);
		routeInfo.setSource(source);
		routeInfo.setPrice(price);
		return routeService.addBusRoute(routeInfo );
	}
	
	@DeleteMapping("/deleteBusRoute")
	public void deleteBusRoute(@RequestParam Long routeId)
	{
		routeService.deleteBusRoute(routeId);
	}
	
	@PostMapping("/updateAvailableSeetsInBus/{routeId}")
	public ResponseEntity<Object> updateAvailableSeetsInBus(
			@PathVariable long routeId,
			@RequestParam(required = false) Long busId ,
			@RequestParam(required = false) String source,
			@RequestParam(required = false) String destination,
			@RequestParam(required = false) Integer price)
	{
		try
		{
			RouteInfo routeInfo = routeService.getRouteById(routeId);
			if(busId != null && busId > 0) 
				routeInfo.setBusId(busId);
			if(destination != null && !destination.isEmpty())
				routeInfo.setDestination(destination);
			if(source != null && !source.isEmpty())
				routeInfo.setSource(source);
			if(price != null && price > 0) 
				routeInfo.setPrice(price);
			routeInfo = routeService.updateBusRoute(routeId,routeInfo );
			return ResponseEntity.ok().body(routeInfo);
		}
		
		catch(Exception e)
		{
			return ResponseEntity.ok().body("No route found with given id");
		}
		 
	}

}
