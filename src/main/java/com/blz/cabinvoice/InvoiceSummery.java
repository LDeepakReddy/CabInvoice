package com.blz.cabinvoice;

import java.util.Objects;

public class InvoiceSummery {
    private int numOfRides;
    private double totalFare;
    private double averageFare;

    public InvoiceSummery(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numOfRides;

    }

    @Override
    public String toString() {
        return "InvoiceSummery{" +
                "numOfRides=" + numOfRides +
                ", totalFare=" + totalFare +
                ", averageFare=" + averageFare +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummery that = (InvoiceSummery) o;
        return numOfRides == that.numOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfRides, totalFare, averageFare);
    }
}
