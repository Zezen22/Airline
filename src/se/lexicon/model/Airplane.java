package se.lexicon.model;

import java.util.Date;
import java.util.List;

public class Airplane implements Runnable {
	
	private int seats, businessSeats;
	private String name;
//	FoodService foodservice= new Foodervice(s);
	static List<Flight> flights;
	static boolean flag=true;
	
	
	// constructor
	public Airplane(String name, int seats, int business) {
		this.name=name;
		this.seats=seats;
		businessSeats=business;
	}

	// 
	static void setFlights(List<Flight> f) {
		flights = f;
	}



	@Override
	public void run() {
//		System.out.println( name +" this thread is runing");
		
		while(flag) {
			synchronized (this) {			
				final Date t= new Date();			
				flights.forEach(s-> {
							if(s.getAirplane()==this && t.after(s.getDepart()) && t.before(s.getArrive())) System.out.println(name +" is flying the route " + s.getRoute() + " whith " + (seats-s.getFreeSeats())+ 
															" passengers where " + (businessSeats-s.getFreeBusinessSeats()) +" travel in Business class");
							else if (s.getAirplane()==this && t.after(new Date(s.getDepart().getTime()-10000)) && t.before(s.getDepart())) {
								System.out.println(name+" takes off ");
//								FoodService foodservice= new Foodervice(s);
								FoodService.serveFood(s);
								}
							
							else if (s.getAirplane()==this && t.after(s.getArrive()) && t.before(new Date(s.getArrive().getTime()+10000)))System.out.println(name + " is landing");;
							
							}); 
			}

			
			try {
				Thread.sleep(9000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
	public String getName() {
		return name;
	}





}
