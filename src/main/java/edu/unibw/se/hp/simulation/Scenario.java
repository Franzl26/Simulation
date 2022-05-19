package edu.unibw.se.hp.simulation;

public interface Scenario<E extends Order> {
    E createOrder();

    Resource<E> getResource();
}
