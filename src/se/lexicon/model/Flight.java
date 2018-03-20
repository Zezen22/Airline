package se.lexicon.model;

import java.util.Date;

public class Flight {

	int flightNumber;
	private Airplane airplane;
	private Date depart, arrive;
	private String route;
	int freeSeats, freeBusinessSeats, freeEconomySeats;
	
	
	// constructor
	public Flight(int flightNumber, Airplane airplane, Date depart, Date arrive, String route) {
		this.flightNumber = flightNumber;
		this.airplane = airplane;
		this.depart = depart;
		this.arrive = arrive;
		this.route=route;
		freeSeats=airplane.getSeats();
		freeBusinessSeats=airplane.getBusinessSeats();
		freeEconomySeats=freeSeats-freeBusinessSeats;
	}
	
	
	// reserve a Seat
	public void reserveBusinessClass() {
		freeSeats--;
		freeBusinessSeats--;
	}
	
	public void reserveEconomyClass() {
		freeSeats--;
		freeEconomySeats--;
	}
	
	// getters
	
	public int getFlightNumber() {
		return flightNumber;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public Date getDepart() {
		return depart;
	}

	public Date getArrive() {
		return arrive;
	}

	public String getRoute() {
		return route;
	}

	public int getFreeSeats() {
		return freeSeats;
	}


	public int getFreeBusinessSeats() {
		return freeBusinessSeats;
	}


	public int getFreeEconomySeats() {
		return freeEconomySeats;
	}


	public void fly() {
		
		// to implement when simulating 
		}
	
	
}
