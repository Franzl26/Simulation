package edu.unibw.se.hp.simulation;

public class BadConfigurationException extends Exception{
    public BadConfigurationException() {
    }

    public BadConfigurationException(String message) {
        super(message);
    }

    public BadConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadConfigurationException(Throwable cause) {
        super(cause);
    }
}
