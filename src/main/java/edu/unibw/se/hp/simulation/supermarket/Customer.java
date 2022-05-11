package edu.unibw.se.hp.simulation.supermarket;

import edu.unibw.se.hp.simulation.Order;

public class Customer extends Order {
    public final int itemNumber;

    Customer(int itemNumber) {
        this.itemNumber = itemNumber;
    }
}
