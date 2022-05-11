package edu.unibw.se.hp.simulation;

public interface Scenario {
    Order createOrder();

    Resource getResource();
}
