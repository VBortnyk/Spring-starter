package dev.spring.starter.exceptions;

public class DataProcessingException extends RuntimeException {
    public DataProcessingException(String msg, Exception e) {
        super(msg, e);
    }
}
