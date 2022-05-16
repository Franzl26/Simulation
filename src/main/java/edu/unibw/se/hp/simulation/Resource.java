package edu.unibw.se.hp.simulation;

import edu.unibw.se.hp.simulation.supermarket.Customer;

public interface Resource {
    long setCurrentOrder(Order order);

    Order removeCurrentOrder();

    boolean isFree();
}
