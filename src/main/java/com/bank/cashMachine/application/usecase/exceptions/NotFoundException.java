package com.bank.cashMachine.application.usecase.exceptions;

import org.springframework.core.NestedRuntimeException;

public class NotFoundException extends NestedRuntimeException {

    public NotFoundException(final String msg) {
        super(msg);
    }
}
