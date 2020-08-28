package com.github.filipefit.msfarms.exception;

public class FarmNotFoundException extends EntityNotFoundException {

    public FarmNotFoundException(String message) {
        super(message);
    }

    public FarmNotFoundException(Long farmId) {
        this(String.format("There is no farm with id %d in the database", farmId));
    }
}
