package edu.unibw.se.hp.simulation.supermarket;

import edu.unibw.se.hp.simulation.Order;

public class Customer extends Order implements Comparable<Customer> {
    public final int itemNumber;

    Customer(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public int compareTo(Customer o) {
        return (int) (o.itemNumber * o.getArrivalTime() - this.itemNumber * this.getArrivalTime()); // richtig
        // return (int) (this.itemNumber * this.getArrivalTime() - o.itemNumber * o.getArrivalTime()); // falsch
    }
}
