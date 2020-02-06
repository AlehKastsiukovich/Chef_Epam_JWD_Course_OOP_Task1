package by.javatraining.chef.exception;

public class VegetableRepositoryException extends Exception {

    public VegetableRepositoryException() {

    }

    public VegetableRepositoryException(String message) {
        super(message);
    }

    public VegetableRepositoryException(Exception e) {
        super(e);
    }

    public VegetableRepositoryException(String message, Exception e) {
        super(message, e);
    }
 }
