package edu.unibw.se.hp.simulation;

abstract public class Order {
    private long arrivalTime;
    private long enterResourceTime;
    private long leaveResourceTime;

    public long getDurationInScenario() {
        return leaveResourceTime - arrivalTime;
    }

    public long getDurationInResource() {
        return leaveResourceTime - enterResourceTime;
    }

    public void setArrivalTime(long time) {
        arrivalTime = time;
    }

    public void setEnterResourceTime(long time) {
        enterResourceTime = time;
    }

    public void setLeaveResourceTime(long time) {
        leaveResourceTime = time;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }
}
