package com.blz.cabinvoice;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = new InvoiceService();

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double totalFare = invoiceService.calculateFare(2.0, 5);
        Assert.assertEquals(25, totalFare, 0);

    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumTotalFare() {
        double totalFare = invoiceService.calculateFare(0.1, 1);
        Assert.assertEquals(5, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5.0, 10)};
//                        new Ride(0.1,1),
//                        new Ride(20,60)};
        double totalFare = invoiceService.calculateFare(rides);
        Assert.assertEquals(85, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummery() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5.0, 10)};
        InvoiceSummery invoiceSummery = invoiceService.calculateTotalFare(rides);
        InvoiceSummery expectedInvoice=new InvoiceSummery(2,85);
        Assert.assertEquals(expectedInvoice,invoiceSummery);
    }

    @Test
    public void givenUserID_ShouldReturnInvoiceSummeryForParticularUser() {
        String userId="Deepak";
        String userID1="tejaswini";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5.0, 10)};
        Ride[] rides1 = {new Ride(5.0, 15),
                new Ride(7.0, 50)};
        invoiceService.addRide(userId,rides);
        invoiceService.addRide(userID1,rides1);
        InvoiceSummery invoiceSummery = invoiceService.getInvoiceSummery(userId);
        InvoiceSummery invoiceSummery1 = invoiceService.getInvoiceSummery(userID1);
        InvoiceSummery expectedInvoice=new InvoiceSummery(2,85);
        InvoiceSummery expectedInvoice1=new InvoiceSummery(2,185);
       Assert.assertEquals(expectedInvoice,invoiceSummery);
        Assert.assertEquals(expectedInvoice1,invoiceSummery1);
    }
}