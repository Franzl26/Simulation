package edu.unibw.se.hp.simulation;

import edu.unibw.se.hp.queue.QueueByArray;
import edu.unibw.se.hp.queue.QueueByList;
import edu.unibw.se.hp.queue.QueueWithPriority;
import edu.unibw.se.hp.simulation.printer.PrinterScenario;
import edu.unibw.se.hp.simulation.supermarket.SupermarketScenario;

import static edu.unibw.se.hp.simulation.Simulation.runSimulation;

public class Main {
    public static void main(String[] args) throws BadConfigurationException {
        mainVariante1();
        mainVariante2();
        queueWithPriority();
    }

    public static void queueWithPriority() {
        System.out.println("Priority: ");
        PrinterScenario printerScenario = new PrinterScenario(3.4, 50);
        System.out.println(runSimulation(printerScenario, new QueueWithPriority<>(), 10000, 30));
        SupermarketScenario supermarketScenario = new SupermarketScenario(4, 10, 30);
        System.out.println(runSimulation(supermarketScenario, new QueueWithPriority<>(), 10000, 30));
    }

    public static void mainVariante1() throws BadConfigurationException {
        System.out.println("Printer:");
        PrinterScenario printerScenario = new PrinterScenario.Builder().maxPages(20).pagesPerSecond(2.9).build();
        System.out.println(runSimulation(printerScenario, new QueueByList<>(), 10000, 5));
        System.out.println(runSimulation(printerScenario, new QueueByArray<>(), 10000, 60));

        System.out.println("Supermarket:");
        SupermarketScenario supermarketScenario = new SupermarketScenario(2, 3, 50);
        System.out.println(runSimulation(supermarketScenario, new QueueByList<>(), 10000, 5));
        System.out.println(runSimulation(supermarketScenario, new QueueByArray<>(), 10000, 60));
    }

    public static void mainVariante2() {
        try {
            System.out.println("Printer:");
            PrinterScenario printerScenario = new PrinterScenario(2.9, 20);
            System.out.println(runSimulation(printerScenario, new QueueByList<>(), 10000, 5));
            System.out.println(runSimulation(printerScenario, new QueueByArray<>(), 10000, 60));

            System.out.println("Supermarket:");
            SupermarketScenario supermarketScenario = new SupermarketScenario.Builder().minItemNumber(3).maxItemsNumber(50).itemsPerSecond(2).build();
            System.out.println(runSimulation(supermarketScenario, new QueueByList<>(), 10000, 5));
            System.out.println(runSimulation(supermarketScenario, new QueueByArray<>(), 10000, 60));
        } catch (BadConfigurationException e) {
            e.printStackTrace(System.out);
            System.out.println("Supermarkt-Scenario konnte nicht erzeugt werden!");
        }
    }
}
