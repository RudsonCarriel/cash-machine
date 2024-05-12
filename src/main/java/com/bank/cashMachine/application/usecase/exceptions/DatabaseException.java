package com.bank.cashMachine.application.usecase.exceptions;

import org.springframework.core.NestedRuntimeException;

public class DatabaseException extends NestedRuntimeException {

    public DatabaseException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
