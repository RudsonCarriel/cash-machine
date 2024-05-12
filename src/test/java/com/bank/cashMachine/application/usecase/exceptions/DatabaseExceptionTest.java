package com.bank.cashMachine.application.usecase.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DatabaseExceptionTest {

    @Test
    public void testDatabaseException() {
        String errorMessage = "Database connection error";
        Throwable cause = new RuntimeException("Underlying cause");

        DatabaseException databaseException = new DatabaseException(errorMessage, cause);

        assertNotNull(databaseException);
        assertEquals(errorMessage, databaseException.getMessage());
        assertEquals(cause, databaseException.getCause());
    }
}