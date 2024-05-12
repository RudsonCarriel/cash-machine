package com.bank.cashMachine.application.usecase.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NotFoundExceptionTest {

    @Test
    public void testNotFoundException() {
        String errorMessage = "Resource not found";

        NotFoundException notFoundException = new NotFoundException(errorMessage);

        assertNotNull(notFoundException);
        assertEquals(errorMessage, notFoundException.getMessage());
    }

}