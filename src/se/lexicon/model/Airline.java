package se.lexicon.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// the class Airline creates our great Airline company
// it has a main Office where the big decisions ar taken,  a customerService (UI) to take orders, and a food service
// we have one only plane in the begining days of our business
// its here we count the money and where we hold the tickets


public class Airline {

		
	static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
		
	// we first create our planes assingn flyes to them
	// we ask the customer service to take care of costumers and reservations
	// we count our earnings
	
	 public static void main(String[] args) {
		 
		 String name= "PowerSky Airlines";
		 Airplane airplane1= new Airplane(10, 5);
		 List<Flight> flights = ScheduleFlights(airplane1);  // we decide wich routes are programmed för today för each airplane

		System.out.println("Wellcome to " + name);	// let's start working
		
		
		
		UI ui = new UI();
	    List<Ticket> tickets= ui.start(flights);
	    	    
	    System.out.println(countEarnings(tickets));
	    
	}

	private static int countEarnings(List<Ticket> tickets) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static ArrayList<Flight> ScheduleFlights(Airplane airplane) {
		
		List<Flight> flights = new ArrayList<Flight>();
		long t= new Date().getTime();
		
		flights.add(new Flight(1, airplane, new Date(t+(4 * ONE_MINUTE_IN_MILLIS)), new Date(t+(6 * ONE_MINUTE_IN_MILLIS)), "Stockholm-Oslo" ));
		flights.add(new Flight(2, airplane, new Date(t+(7 * ONE_MINUTE_IN_MILLIS)), new Date(t+(9 * ONE_MINUTE_IN_MILLIS)),  "Oslo-Köpenhamn"));
		flights.add(new Flight(3, airplane, new Date(t+(10 * ONE_MINUTE_IN_MILLIS)), new Date(t+(12 * ONE_MINUTE_IN_MILLIS)), "Köpenhamn-Stockholm" ));
		flights.add(new Flight(4, airplane, new Date(t+(13 * ONE_MINUTE_IN_MILLIS)), new Date(t+(15 * ONE_MINUTE_IN_MILLIS)), "Stockholm-Köpenhamn"));
		flights.add(new Flight(5, airplane, new Date(t+(16 * ONE_MINUTE_IN_MILLIS)), new Date(t+(18 * ONE_MINUTE_IN_MILLIS)), "Köpenhamn-Oslo"));
		flights.add(new Flight(6, airplane, new Date(t+(19 * ONE_MINUTE_IN_MILLIS)), new Date(t+(21 * ONE_MINUTE_IN_MILLIS)), "Oslo-Stockholm"));
		return null;
	}



}
