package se.lexicon.model;

import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class FoodService {
	
//	Flight flight;

//	public FoodService(Flight flight) {
//		this.flight = flight;
//	}

	public static void serveFood(Flight flight) {
		int bussinessSeats= flight.getAirplane().getBusinessSeats()-flight.getFreeBusinessSeats();
		System.out.println("All the " + bussinessSeats + " business passengers in this flight get food för free");
		int economySeats = flight.getAirplane().getEconomySeats()-flight.getFreeEconomySeats();
		System.out.println(economySeats + " passengers in economy class, how many want food for 5000sek?");
		Scanner in = new Scanner(System.in);
		int num=0;
		try {
			num = in.nextInt();
		} catch (Exception e) {
			System.out.println("not a proper choice, you get a two minutes flights without food as punishment");
		}
		
		
		if (num<0 || num> economySeats) System.out.println("go away, this is a serious job");
	}

}
