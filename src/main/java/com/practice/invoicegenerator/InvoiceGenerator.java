package com.practice.invoicegenerator;

import com.practice.invoicesummary.InvoiceSummary;
import com.practice.ride.Ride;
import com.practice.riderepository.RideRepository;
//import com.practice.riderepository.rideRepository;

public class InvoiceGenerator {
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;
	private RideRepository rideRepository;
	
	public InvoiceGenerator() {
		this.rideRepository = new RideRepository();
	}
	public double calculateFare(double distance, int time) {
		// TODO Auto-generated method stub
		double totalFare =  distance * MINIMUM_COST_PER_KILOMETER + time *COST_PER_TIME;
		if(totalFare < MINIMUM_FARE) {
			return MINIMUM_FARE;
		}
		return totalFare;
	}
	
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare  = 0;
		for(Ride ride:rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	public void addRides(String userId, Ride[] rides) {
		// TODO Auto-generated method stub
		rideRepository.addRides(userId, rides);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		// TODO Auto-generated method stub
		return this.calculateFare(rideRepository.getRides(userId));
	}
}
