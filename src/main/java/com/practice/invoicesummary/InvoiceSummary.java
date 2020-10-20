package com.practice.invoicesummary;

public class InvoiceSummary {

	private double totalFare;
	private int numberOfRides;
	private double averageFare;

	public InvoiceSummary(int numberOfRides, double totalFare) {
		// TODO Auto-generated constructor stub
		this.numberOfRides = numberOfRides;
		this.totalFare = totalFare;
		this.averageFare = this.totalFare / numberOfRides;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		InvoiceSummary that = (InvoiceSummary) o;
		return numberOfRides == that.numberOfRides &&
				Double.compare(that.totalFare, totalFare) == 0 &&
				Double.compare(that.averageFare, averageFare) == 0;
	}

}
