package se.lexicon.ui;


import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import se.lexicon.model.Flight;
import se.lexicon.model.Ticket;

public class UI {

	// Return Number of Tickets
	public List<Ticket> start(List<Flight> flights) {

		List<Ticket> tickets = new ArrayList<Ticket>();

		//int TicketPrice = 0;

		boolean isBusiness = false;
		boolean isRunning = true;  
	
		Scanner scanner = new Scanner(System.in);

		System.out.println("Flight Manager version 1.0");
		System.out.println("-----");

		
		do {
		
		System.out.println("Passanger's Full Name?");
		String name = scanner.next();
	
		System.out.println("Where are you flying to?");
		
		int i = 0;
		for (Flight myflight : flights) {
			i++;
			final Date t = new Date(); 
			if (myflight.getFreeSeats()>0 && t.before(new Date(myflight.getDepart().getTime()))) 
			System.out.println(i + " " + myflight.getRoute() +" on " + myflight.getDepart());
		}	
		
		int route = 1;
		 
		try {
			route = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid route. We can choose the route for you");
		}
		
		Flight myflight = flights.get(route-1); 

		System.out.println("How many tickets do you want? We have "  + myflight.getFreeEconomySeats() + " left in Economy class and " + myflight.getFreeBusinessSeats() + " in Business Class");
		int numberOfTickets = 0;
		
			try {
				numberOfTickets = scanner.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("Not a number");
			} catch (Exception e) { 
				System.out.println("Invalid choice");
			}
			
		if (numberOfTickets <= myflight.getFreeBusinessSeats() && numberOfTickets <= myflight.getFreeEconomySeats()) {
		
		System.out.println("Business Class?: 1.- Business 2.- Economy");
		
		isBusiness = scanner.nextInt() == 1;
		}
		else if (numberOfTickets <= myflight.getFreeBusinessSeats())isBusiness = true; 
		
		else if (numberOfTickets <= myflight.getFreeEconomySeats())isBusiness=false; 
		
		else System.out.println("We cannot book that many tickets"); //TODO Esto va a dar problemas 
		
	
			
		Flight thisFlight = flights.get(route - 1);
	
		if (isBusiness) {
			if (thisFlight.getFreeBusinessSeats() >= numberOfTickets) { 
				thisFlight.reserveBusinessClass(numberOfTickets); //TODO Se puede reservan demasiados tickets WARNING REMOVE 
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
		
		
		System.out.println("More passengers? y/n ");
		
		if (scanner.next().equals("n")) isRunning = false;  
			
		} while(isRunning); 

		return tickets;

	}
}
