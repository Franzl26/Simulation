package edu.unibw.se.hp.simulation;

public interface Resource {
    long setCurrentOrder(Order order);

    Order removeCurrentOrder();

    boolean isFree();
}
