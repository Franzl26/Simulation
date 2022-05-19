package edu.unibw.se.hp.simulation.supermarket;

import edu.unibw.se.hp.simulation.Order;
import edu.unibw.se.hp.simulation.Resource;

public class Checkout implements Resource<Customer> {
    private final int itemsPerSecond;
    private Customer currentCustomer = null;

    public Checkout(int itemsPerSecond) {
        this.itemsPerSecond = itemsPerSecond;
    }

    @Override
    public long setCurrentOrder(Customer order) {
        currentCustomer = order;
        return currentCustomer.itemNumber / itemsPerSecond;
    }

    @Override
    public Customer removeCurrentOrder() {
        Customer temp = currentCustomer;
        currentCustomer = null;
        return temp;
    }

    @Override
    public boolean isFree() {
        return currentCustomer == null;
    }
}
