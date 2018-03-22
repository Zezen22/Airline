import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import se.lexicon.model.Airplane;
import se.lexicon.model.Flight;
import se.lexicon.model.Ticket;
import se.lexicon.ui.ui;

public class main {

	public static void main(String[] args) {

		ui ui = new ui(); 
		Airplane myairplane = new Airplane("miguel", 10, 5); 
		Flight myflight = new Flight(12, myairplane, new Date(), new Date(), "Route");
		Flight myflight1 = new Flight(12, myairplane, new Date(), new Date(), "Oslo");
		
		Flight myflight2 = new Flight(12, myairplane, new Date(), new Date(), "helsinki");
		
		Flight myflight3 = new Flight(12, myairplane, new Date(), new Date(), "Tampere");
		
		
		List<Flight> flights = new ArrayList<Flight>();
		
	   flights.add(myflight);
	   flights.add(myflight1);
	   flights.add(myflight2);
	   flights.add(myflight3);
		
		
		List<Ticket> tickets = ui.start(flights);
		
		tickets.forEach(s -> System.out.println(s.getPrice()));
	}

}
