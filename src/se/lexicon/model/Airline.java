package se.lexicon.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// the class Airline creates our great Airline company
// it has a main Office where the big decisions are taken,  a customerService (UI) to take orders, and a food service
// we have three planes
// its here we count the money and when we get the tickets from the customer service

public class Airline {

	static final long ONE_MINUTE_IN_MILLIS = 60000;// millisecs

	// we first create our planes assign them some flyes 
	// we ask the customer service to take care of costumers and reservations
	// we count our earnings

	public static void main(String[] args) {

		String name = "PowerSky Airlines";
		Airplane airplane1 = new Airplane("Tornado", 10, 5);
		Airplane airplane2 = new Airplane("Blixten", 10, 5);
		Airplane airplane3 = new Airplane("Thunder", 10, 5);

		System.out.println("Wellcome to " + name);

		List<Flight> flights = ScheduleFlights(airplane1); // we decide wich routes are programmed för today för each airplane
		flights.addAll(ScheduleFlights(airplane2));
		flights.addAll(ScheduleFlights(airplane3));

		// time for the customer service to do they're jobb
		demoUI ui = new demoUI();
		List<Ticket> tickets = ui.start(flights);
		
		// counting money is the best part of a good business
		System.out.println("We har haft earnings for " + countEarnings(tickets) + "sek today");
		// we look how many empty places where in each flight 
		flights.forEach(s -> System.out.println(s.getAirplane().getName() + "'s flight nb " + s.getFlightNumber()
				+ " had " + s.getFreeSeats() + " free seats. " + s.getFreeBusinessSeats() + " in business class"));

		// time for the planes to serve our customers
		// each plane gets the companies whole List of scheduled flights and they looks themselves for the info is relevant to them 
		Airplane.setFlights(flights);
		Thread thisThread = new Thread(airplane1);
		thisThread.start();
		
		thisThread = new Thread(airplane2);
		thisThread.start();
		
		thisThread = new Thread(airplane3);
		thisThread.start();

		
		try {
			Thread.sleep(60000*20);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Airplane.flag= false;
		try {
			thisThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("goodbye");

	}

	private static int countEarnings(List<Ticket> tickets) {
		int total = 0;
		for (Ticket thisTicket : tickets) {
			total = total + thisTicket.getPrice(); // ej trådsäkert
		}

		// tickets.forEach(s-> total= total+ s.getPrice()); why doesn't this work??
		return (int) (total * 0.3);
	}

	private static List<Flight> ScheduleFlights(Airplane airplane) {

		List<Flight> flights = new ArrayList<Flight>();

		Object[] options = { "Stockholm-Oslo", "Oslo-Köpenhamn", "Köpenhamn-Stockholm", "Stockholm-Köpenhamn",
				"Köpenhamn-Oslo", "Oslo-Stockholm" };
		Scanner in = new Scanner(System.in);

		long t = new Date().getTime();
		System.out.println("choose next route för our plane " + airplane.getName());
		for (int i = 0; i < options.length; i++)
			System.out.println((i + 1) + " " + options[i]);
		for (int i = 0; i < 4; i++) {
			int num = in.nextInt() - 1;
			flights.add(new Flight(i + 1, airplane, new Date(t + (2 + 3 * i) * ONE_MINUTE_IN_MILLIS),
					new Date(t + (4 + 3 * i) * ONE_MINUTE_IN_MILLIS), options[num].toString()));
			System.out.println("next trip?");
		}
		return flights;
	}

}
