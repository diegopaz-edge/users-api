package br.com.usersapi.services.exceptions;

import java.io.Serial;

public class DataIntegrityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 2318636798951000772L;

    public DataIntegrityException(String msg) {
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
