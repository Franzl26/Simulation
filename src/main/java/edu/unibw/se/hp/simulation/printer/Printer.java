package edu.unibw.se.hp.simulation.printer;

import edu.unibw.se.hp.simulation.Order;
import edu.unibw.se.hp.simulation.Resource;

public class Printer implements Resource {
    private final double pagesPerSecond;
    private PrintJob currentPrinterJob = null;

    Printer(double pagesPerSecond) {
        this.pagesPerSecond = pagesPerSecond;
    }

    @Override
    public long setCurrentOrder(Order order) {
        currentPrinterJob = (PrintJob) order;
        return (long) (currentPrinterJob.pages / pagesPerSecond);
    }

    @Override
    public Order removeCurrentOrder() {
        PrintJob temp = currentPrinterJob;
        currentPrinterJob = null;
        return temp;
    }

    @Override
    public boolean isFree() {
        return currentPrinterJob == null;
    }
}
