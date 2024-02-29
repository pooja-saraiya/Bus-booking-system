package com.busbooking.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.busbooking.admin.model.RouteInfo;
@Repository
public interface RouteRepository extends JpaRepository<RouteInfo, Long> 
{
	public List<RouteInfo> findAllByBusId(@Param(value = "busId") long busId);
}
