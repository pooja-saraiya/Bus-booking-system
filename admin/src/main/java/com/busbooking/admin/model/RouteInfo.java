package com.busbooking.admin.model;

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
@Table(name ="bus_route_info")
public class RouteInfo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "route_id", nullable = false)
    private Long routeId;
	
	@Column(name = "bus_id", nullable = false)
    private Long busId;
	
	@Column(name = "source_station", nullable = false, length= 15)
    private String source;
	
	@Column(name = "destination", nullable = false, length= 15)
    private String destination;
	
	@Column(name = "price", nullable = false)
    private Integer price;
	
	/*
	 * @Column(name = "route_start_time_in_HH24MM", nullable = false) private
	 * Integer startTime;
	 * 
	 * @Column(name = "route_end_time_in_HH24MM", nullable = false) private Integer
	 * endTime;
	 */

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	/*
	 * public Integer getStartTime() { return startTime; }
	 * 
	 * public void setStartTime(Integer startTime) { this.startTime = startTime; }
	 * 
	 * public Integer getEndTime() { return endTime; }
	 * 
	 * public void setEndTime(Integer endTime) { this.endTime = endTime; }
	 */
	
	
	
}
