package com.github.filipefit.msfarms.exception;

public class NotEnoughFarmCapacityException extends BusinessException {

    public NotEnoughFarmCapacityException(String message) {
        super(message);
    }

    public NotEnoughFarmCapacityException(String message, Throwable cause) {
        super(message, cause);
    }
}
