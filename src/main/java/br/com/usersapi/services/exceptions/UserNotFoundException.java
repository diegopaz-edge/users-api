package br.com.usersapi.services.exceptions;

import java.io.Serial;

public class UserNotFoundException extends ClassNotFoundException {

    @Serial
    private static final long serialVersionUID = 2318636798951000772L;

    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
