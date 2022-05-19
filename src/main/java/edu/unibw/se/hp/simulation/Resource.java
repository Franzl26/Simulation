package edu.unibw.se.hp.simulation;

public interface Resource<E extends Order> {
    long setCurrentOrder(E order);

    E removeCurrentOrder();

    boolean isFree();
}
