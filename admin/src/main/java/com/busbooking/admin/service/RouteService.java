package com.busbooking.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busbooking.admin.model.RouteInfo;
import com.busbooking.admin.repository.RouteRepository;

@Service
public class RouteService 
{
	@Autowired
	private RouteRepository routeRepository;

	public List<RouteInfo> getAllBusRoutes() 
	{
		return routeRepository.findAll();
	}

	public List<RouteInfo> getBusRouteById(long routeId) 
	{
		return routeRepository.findAllByBusId(routeId);
	}

	public RouteInfo addBusRoute(RouteInfo routeInfo) 
	{
		return routeRepository.save(routeInfo);
	}

	public void deleteBusRoute(Long routeId)
	{
		routeRepository.deleteById(routeId);
	}

	public RouteInfo updateBusRoute(long routeId, RouteInfo routeInfo)
	{
		return routeRepository.save(routeInfo);
	}

	public RouteInfo getRouteById(long routeId)
	{
		return routeRepository.findById(routeId).orElseThrow();
	}

	
}
