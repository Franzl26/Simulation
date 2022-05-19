package edu.unibw.se.hp.simulation.supermarket;

import edu.unibw.se.hp.simulation.BadConfigurationException;
import edu.unibw.se.hp.simulation.Resource;
import edu.unibw.se.hp.simulation.Scenario;

public class SupermarketScenario implements Scenario<Customer> {
    private final int minItemNumber;
    private final int maxItemNumber;
    private final Checkout checkout;

    public SupermarketScenario(int itemsPerSecond, int minItemNumber, int maxItemNumber) {
        this.minItemNumber = minItemNumber;
        this.maxItemNumber = maxItemNumber;
        checkout = new Checkout(itemsPerSecond);
    }

    private SupermarketScenario(Builder builder) {
        minItemNumber = builder.minItemNumber;
        maxItemNumber = builder.maxItemNumber;
        checkout = new Checkout(builder.itemsPerSecond);
    }

    @Override
    public Customer createOrder() {
        return new Customer((int) (Math.random() * (maxItemNumber - minItemNumber) + minItemNumber));
    }

    @Override
    // public Resource<Customer> getResource() {
    public Checkout getResource() {
        return checkout;
    }

    public static class Builder {
        private int minItemNumber = -1;
        private int maxItemNumber = -1;
        private int itemsPerSecond = -1;

        public Builder minItemNumber(int items) {
            if (items <= 0) throw new IllegalArgumentException("minItemNumber should be greater then 0!");
            minItemNumber = items;
            return this;
        }

        public Builder maxItemsNumber(int items) {
            if (items <= 0) throw new IllegalArgumentException("maxItemNumber should be greater then 0!");
            maxItemNumber = items;
            return this;
        }

        public Builder itemsPerSecond(int items) {
            if (items <= 0) throw new IllegalArgumentException("itemsPerSecond should be greater then 0!");
            itemsPerSecond = items;
            return this;
        }

        public SupermarketScenario build() throws BadConfigurationException{
            if (maxItemNumber < 0 || minItemNumber < 0 || itemsPerSecond < 0) throw new IllegalArgumentException("Some values are not initialised!");
            if (minItemNumber > maxItemNumber) throw new BadConfigurationException("minItemNumber is bigger then maxItemsNumber!");
            return new SupermarketScenario(this);
        }
    }
}
