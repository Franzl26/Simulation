package edu.unibw.se.hp.simulation.printer;

import edu.unibw.se.hp.simulation.Order;

public class PrintJob extends Order {
    public final int pages;

    PrintJob(int pages) {
        this.pages = pages;
    }
}
