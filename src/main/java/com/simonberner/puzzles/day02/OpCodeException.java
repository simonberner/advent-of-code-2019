package com.simonberner.puzzles.day02;

// Custom exception: https://www.baeldung.com/java-new-custom-exception
public class OpCodeException extends Exception {

    public OpCodeException(String errorMessage) {
        super(errorMessage);
    }
}
