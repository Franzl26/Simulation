package edu.unibw.se.hp.simulation.printer;

import edu.unibw.se.hp.simulation.Order;
import edu.unibw.se.hp.simulation.Resource;

public class Printer implements Resource<PrintJob> {
    private final double pagesPerSecond;
    private PrintJob currentPrinterJob = null;

    Printer(double pagesPerSecond) {
        this.pagesPerSecond = pagesPerSecond;
    }

    @Override
    public long setCurrentOrder(PrintJob order) {
        currentPrinterJob = order;
        return (long) (currentPrinterJob.pages / pagesPerSecond);
    }

    @Override
    public PrintJob removeCurrentOrder() {
        PrintJob temp = currentPrinterJob;
        currentPrinterJob = null;
        return temp;
    }

    @Override
    public boolean isFree() {
        return currentPrinterJob == null;
    }
}
