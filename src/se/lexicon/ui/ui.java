package se.lexicon.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import se.lexicon.model.Flight;
import se.lexicon.model.Reservation;
import se.lexicon.model.Ticket;

public class ui {

	// Return Number of Tickets
	public static List<Ticket> start(List<Flight> flights) {

		List<Ticket> tickets = new ArrayList<Ticket>();

		int TicketPrice = 0;

		boolean isBusiness = false;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Flight Manager version 1.0");
		System.out.println("-----");

		System.out.println("Name of Passanger?");
		String name = scanner.next();

		System.out.println("Where are you flying to?");

		int i = 0;
		for (Flight myflight : flights) {
			i++;
			System.out.println(i + " " + myflight.getRoute());
		}
		int route = 1;
		try {
			route = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid route. We can choose the route for you");

		}

		System.out.println("How many tickets fo you want?");
		int numberOfTickets = 0;

		try {
			numberOfTickets = scanner.nextInt();

		} catch (Exception e) {
			System.out.println("Invalid choice");
		}

		System.out.println("Business Class?: 1.- Business X.- Economy");
		isBusiness = scanner.nextInt() == 1;

		Flight thisFlight = flights.get(route - 1);

		if (isBusiness) {
			if (thisFlight.getFreeBusinessSeats() >= numberOfTickets) {
				thisFlight.reserveBusinessClass(numberOfTickets);
				Ticket newTicket = new Ticket(name, thisFlight.getRoute(), 20000 * numberOfTickets, numberOfTickets,
						thisFlight.getDepart(), thisFlight.getArrive(), true);
				tickets.add(newTicket);
				
			}
			
				else System.out.println("Sorry, We have only " + thisFlight.getFreeBusinessSeats() + "left");
						
			}
						
		else {
			if (thisFlight.getFreeEconomySeats() >= numberOfTickets) {
				thisFlight.reserveEconomyClass(numberOfTickets);
				Ticket newTicket = new Ticket(name, thisFlight.getRoute(), 5000 * numberOfTickets, numberOfTickets,
						thisFlight.getDepart(), thisFlight.getArrive(), false);
				tickets.add(newTicket);			
			}
			else System.out.println("Sorry, We have only " + thisFlight.getFreeEconomySeats() + "left");
			
		}

		return tickets;

	}
}