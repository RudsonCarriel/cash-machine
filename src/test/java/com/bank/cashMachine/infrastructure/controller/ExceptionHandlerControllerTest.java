package com.bank.cashMachine.infrastructure.controller;

import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionHandlerControllerTest {

    private final ExceptionHandlerController controller = new ExceptionHandlerController();

    @Test
    void handleHttpMessageNotReadableException() {
        ResponseEntity<ErrorResponse> responseEntity = controller.handleHttpMessageNotReadableException(
                new HttpMessageNotReadableException("Invalid input")
        );

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Entrada inválida, por favor forneça um número válido.", responseEntity.getBody().message());
    }


    @Test
    void handleDataAccessException() {
        ResponseEntity<ErrorResponse> responseEntity = controller.handleDataAccessException(
                new DataAccessException("Database error") {}
        );

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Erro no acesso ao banco de dados.", responseEntity.getBody().message());
    }

    @Test
    void handleException() {
        ResponseEntity<ErrorResponse> responseEntity = controller.handleException(
                new Exception("Unknown error")
        );

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Ocorreu um erro desconhecido.", responseEntity.getBody().message());
    }
}