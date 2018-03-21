package se.lexicon.model;

import java.util.Date;

public class Flight {
	
	// the Flight class records the most interesting information for each flight and two methods to make reservations

	private int flightNumber;
	private Airplane airplane;
	private Date depart, arrive;
	private String route;
	private int freeSeats, freeBusinessSeats, freeEconomySeats;
	private boolean flightIsCompleate, noBusinessClassPlacesLeft, noEconomyClassplacesLeft;
	
	
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
		if(freeSeats== 0) {
			flightIsCompleate = true;
//			System.out.println("flight nb "+ flightNumber + " in "+ airplane.getName() +" is complete");
		}
		if (freeBusinessSeats==0)	{
			noBusinessClassPlacesLeft = true;
//			System.out.println("flight nb "+ flightNumber + " in "+ airplane.getName() +" has no more business class free places");
		}
	}
	
	public void reserveEconomyClass() {
		freeSeats--;
		freeEconomySeats--;
		if(freeSeats== 0) {
			flightIsCompleate = true;
//			System.out.println("flight nb "+ flightNumber + " in "+ airplane.getName() +" is complete");
		}
		if (freeEconomySeats==0)	{
			noEconomyClassplacesLeft = true;
//			System.out.println("flight nb "+ flightNumber + " in "+ airplane.getName() +" has no more economy class free places");
		}
	}
	
	// getters
	
	public boolean isFlightIsCompleate() {
		return flightIsCompleate;
	}


	public boolean isNoBusinessClassPlacesLeft() {
		return noBusinessClassPlacesLeft;
	}


	public boolean isNoEconomyClassplacesLeft() {
		return noEconomyClassplacesLeft;
	}


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

	
	
}
