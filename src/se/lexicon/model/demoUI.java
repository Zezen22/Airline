package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;

public class demoUI {
	
	static final int potentialCustomers= 119;

	public List<Ticket> start(List<Flight> flights) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		//List<Reservation> reservation = new ArrayList<Reservation>();   ///  wHY??
		
		for (int kund = 0; kund < potentialCustomers; kund++) {					// 10 kunder
			
			int numberPassengers = ((int) Math.random()*4)+1;		// random mängd passagerara
			boolean isBusiness = Math.random()>0.7;					// 70% av folket vill resa i economy class
			
			Flight thisFlight;
			do {
				int flightNumber = (int) (Math.random()*flights.size());	// ramdom flyght
				thisFlight = flights.get(flightNumber);
			}
			while (thisFlight.isFlightIsCompleate());
			
			

		
			if(isBusiness) {
				if(thisFlight.getFreeBusinessSeats()>=numberPassengers) {
					thisFlight.reserveBusinessClass(numberPassengers);
					Ticket newTicket= new Ticket("Mr random", thisFlight.getRoute(), 20000*numberPassengers, numberPassengers, thisFlight.getDepart(), thisFlight.getArrive(), true);
					tickets.add(newTicket);
				}
				//else System.out.println("sorry, business class is complete");
				
			}
			else {
				if(thisFlight.getFreeEconomySeats()>=numberPassengers) {
					thisFlight.reserveEconomyClass(numberPassengers);
					Ticket newTicket= new Ticket("Mr random", thisFlight.getRoute(), 5000*numberPassengers, numberPassengers, thisFlight.getDepart(), thisFlight.getArrive(), false);
					tickets.add(newTicket);
				}
				//else System.out.println("sorry, no place in economy class for you");
			}
				
		}
		
		
		return tickets;
	}

}
