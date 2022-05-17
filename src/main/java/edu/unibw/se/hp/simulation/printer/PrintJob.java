package edu.unibw.se.hp.simulation.printer;

import edu.unibw.se.hp.simulation.Order;

public class PrintJob extends Order implements Comparable<PrintJob> {
    public final int pages;

    PrintJob(int pages) {
        this.pages = pages;
    }

    @Override
    public int compareTo(PrintJob o) {
        return (int) (o.pages * o.getArrivalTime() - this.pages * this.getArrivalTime()); // richtig
        // return (int) (this.pages * this.getArrivalTime() - o.pages * o.getArrivalTime()); // falsch
    }
}
