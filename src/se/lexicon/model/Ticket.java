package se.lexicon.model;

import java.util.Date;

public class Ticket {
	
	private String customerName, route;
	private int totalPrice, numberPassangers;
	private Date departureTime, arrivalTime;
	private boolean bussiness;
	
	
	public Ticket(String customerName, String route, int totalPrice, int numberPassangers, Date departureTime,
			Date arrivalTime, boolean bussiness) {
		this.customerName = customerName;
		this.route = route;
		this.totalPrice = totalPrice;
		this.numberPassangers = numberPassangers;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.bussiness = bussiness;
	}
	public int getPrice() {
		return totalPrice;
	}
	

}
