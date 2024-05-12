package com.bank.cashMachine.infrastructure.controller;

import com.bank.cashMachine.application.usecase.CashMachineUserCase;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.*;

class CashMachineControllerTest {

    @Mock
    private CashMachineUserCase service;

    @InjectMocks
    private CashMachineController controller;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void withdraw_ValidRequest_ReturnsResponseEntity() throws BadRequestException {
        LootRequest lootRequest = new LootRequest(100.0); // Passando o valor como argumento
        when(service.withdrawCash(anyInt())).thenReturn(new DataResponse(anyList(),"Success"));
        ResponseEntity<DataResponse> responseEntity = controller.withdraw(lootRequest);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Success", responseEntity.getBody().message());
    }

}