package se.lexicon.model;

public class Airplane {
	
	int seats, businessSeats;
	
	
	public Airplane(int seats, int business) {
		this.seats=seats;
		businessSeats=business;
	}

	
	
	// geters
	public int getSeats() {
		return seats;
	}

	public int getBusinessSeats() {
		return businessSeats;
	}
	public int getEconomySeats() {
		return seats-businessSeats;
	}

}
