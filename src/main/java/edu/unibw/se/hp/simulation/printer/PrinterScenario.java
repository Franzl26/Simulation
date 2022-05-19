package edu.unibw.se.hp.simulation.printer;

import edu.unibw.se.hp.simulation.BadConfigurationException;
import edu.unibw.se.hp.simulation.Scenario;

public class PrinterScenario implements Scenario<PrintJob> {
    private final int maxPages;
    private final Printer printer;

    public PrinterScenario(double pagesPerSecond, int maxPages) {
        printer = new Printer(pagesPerSecond);
        this.maxPages = maxPages;
    }

    private PrinterScenario(Builder builder) {
        printer = new Printer(builder.pagesPerSecond);
        maxPages = builder.maxPages;
    }

    @Override
    public PrintJob createOrder() {
        return new PrintJob((int) (Math.random() * maxPages + 1));
    }

    @Override
    // public Resource<PrintJob> getResource() {
    public Printer getResource() {
        return printer;
    }

    public static class Builder {
        private int maxPages = -1;
        private double pagesPerSecond = -1.0;

        public Builder maxPages(int maxPages) {
            if (maxPages <= 0) throw new IllegalArgumentException("maxPages should be greater then 0!");
            this.maxPages = maxPages;
            return this;
        }

        public Builder pagesPerSecond(double pagesPerSecond) {
            if (pagesPerSecond <= 0) throw new IllegalArgumentException("pagesPerSecond should be greater then 0!");
            this.pagesPerSecond = pagesPerSecond;
            return this;
        }

        public PrinterScenario build() throws BadConfigurationException {
            if (maxPages <= 0 || pagesPerSecond <= 0)
                throw new BadConfigurationException("Some values are not initialised!");
            return new PrinterScenario(this);
        }
    }
}
