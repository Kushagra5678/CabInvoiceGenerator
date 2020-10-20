package com.practice.invoicegenerator;

import org.junit.Assert;
import org.junit.Test;

import com.practice.invoicesummary.InvoiceSummary;
import com.practice.ride.Ride;

public class InvoiceServiceTest {
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceOrTime_ShouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
//	@Test
//	public void givenMultipleRides_ShouldReturnTotalFare() {
//		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
//		Ride[] rides = {new Ride(2.0, 5),
//				new Ride(0.1, 1)
//		};
//		double fare = invoiceGenerator.calculateFare(rides);
//		Assert.assertEquals(30, fare, 0.0);
//	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = {new Ride(2.0, 5),
						new Ride(0.1, 1)
		};
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
	@Test
	public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
		String userId = "a@b.com";
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = {new Ride(2.0, 5),
						new Ride(0.1, 1)
		};
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
}
