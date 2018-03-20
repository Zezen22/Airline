package se.lexicon.model;

public class Reservation {
	
	private Flight flight;
	private Airplane airplane;
	private boolean business;
	private int price= 5000;  // economy is default
	static int totalReservations=0;
	private int reservationnummer;
	private String customer;
	
	
	public Reservation(Flight flight, boolean business, String customer) {
		this.flight = flight;
		this.business = business;
		if (business) price=20000;
		airplane=flight.getAirplane();
		reservationnummer=totalReservations;
		totalReservations++;
		this.customer=customer;
	}


	public static int getTotalReservations() {
		return totalReservations;
	}


	public int getReservationNummber() {
		return reservationnummer;
	}


	public Flight getFlight() {
		return flight;
	}


	public Airplane getAirplane() {
		return airplane;
	}


	public boolean isBusiness() {
		return business;
	}

	public int getPrice() {
		return price;
	}
	
	

}
