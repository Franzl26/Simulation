package edu.unibw.se.hp.simulation;

import edu.unibw.se.hp.queue.Queue;

import java.text.DecimalFormat;

public class Simulation {
    public static <O extends Order> String runSimulation(Scenario<O> scenario, Queue<O> queue, int numberOfOrdersToCreate, long meanEnterInterval) {
        long timeNextOrderArrives = -(long) (Math.log(Math.random()) * meanEnterInterval);
        long timeNextOrderLeaveResource = Long.MAX_VALUE;
        double totalDurationInScenario = 0;
        double totalDurationInResource = 0;
        int countCreatedOrders = 0;
        int countFinishedOrders = 0;
        Resource<O> resource = scenario.getResource();
        while (countCreatedOrders < numberOfOrdersToCreate || !resource.isFree() || !queue.isEmpty()) {
            long currentTime = Math.min(timeNextOrderArrives, timeNextOrderLeaveResource);
            if (currentTime == timeNextOrderArrives) {
                O order = scenario.createOrder();
                order.setArrivalTime(currentTime);
                queue.enqueue(order);
                countCreatedOrders++;
                timeNextOrderArrives = (countCreatedOrders == numberOfOrdersToCreate) ?
                        Long.MAX_VALUE : currentTime - (long) (Math.log(Math.random()) * meanEnterInterval);
            }
            if (currentTime == timeNextOrderLeaveResource) {
                Order order = resource.removeCurrentOrder();
                order.setLeaveResourceTime(currentTime);
                countFinishedOrders++;
                totalDurationInScenario += order.getDurationInScenario();
                totalDurationInResource += order.getDurationInResource();
                timeNextOrderLeaveResource = Long.MAX_VALUE;
            }
            if (resource.isFree() && !queue.isEmpty()) {
                O order = queue.dequeue();
                order.setEnterResourceTime(currentTime);
                timeNextOrderLeaveResource = currentTime + resource.setCurrentOrder(order);
            }
        }
        DecimalFormat myFormatter = new DecimalFormat("00000.00");
        return "Verweildauer: " + myFormatter.format(totalDurationInScenario / countFinishedOrders)
                + " - Wartedauer: " + myFormatter.format((totalDurationInScenario - totalDurationInResource) / countFinishedOrders)
                + " - Bearbeitungsdauer: " + myFormatter.format(totalDurationInResource / countFinishedOrders);
    }
}