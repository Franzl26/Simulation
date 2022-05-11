package edu.unibw.se.hp.simulation.supermarket;

import edu.unibw.se.hp.simulation.Order;
import edu.unibw.se.hp.simulation.Resource;

public class Checkout implements Resource {
    private final int itemsPerSecond;
    private Customer currentCustomer = null;

    public Checkout(int itemsPerSecond) {
        this.itemsPerSecond = itemsPerSecond;
    }

    @Override
    public long setCurrentOrder(Order order) {
        currentCustomer = (Customer) order;
        return currentCustomer.itemNumber / itemsPerSecond;
    }

    @Override
    public Order removeCurrentOrder() {
        Customer temp = currentCustomer;
        currentCustomer = null;
        return temp;
    }

    @Override
    public boolean isFree() {
        return currentCustomer == null;
    }
}
