package com.busbooking.booking.model;

public class BusView
{
	
    private Long busId;
    private String busNumber;
    private String busType;
    private String busOwner;
    private Integer busCapacity;
    private long busAddedDateInEpoch;
    private long busupdatedDateInEpoch;
    private Integer busAvailableCapacity;
    private Boolean busInTransit;

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusOwner() {
		return busOwner;
	}

	public void setBusOwner(String busOwner) {
		this.busOwner = busOwner;
	}

	public Integer getBusCapacity() {
		return busCapacity;
	}

	public void setBusCapacity(Integer busCapacity) {
		this.busCapacity = busCapacity;
	}

	public long getBusAddedDateInEpoch() {
		return busAddedDateInEpoch;
	}

	public void setBusAddedDateInEpoch(long busAddedDateInEpoch) {
		this.busAddedDateInEpoch = busAddedDateInEpoch;
	}

	public long getBusupdatedDateInEpoch() {
		return busupdatedDateInEpoch;
	}

	public void setBusupdatedDateInEpoch(long busupdatedDateInEpoch) {
		this.busupdatedDateInEpoch = busupdatedDateInEpoch;
	}

	public Integer getBusAvailableCapacity() {
		return busAvailableCapacity;
	}

	public void setBusAvailableCapacity(Integer busAvailableCapacity) {
		this.busAvailableCapacity = busAvailableCapacity;
	}

	public Boolean getBusInTransit() {
		return busInTransit;
	}

	public void setBusInTransit(Boolean busInTransit) {
		this.busInTransit = busInTransit;
	}

}
