package com.bank.cashMachine.application.usecase;

import static org.junit.jupiter.api.Assertions.*;

import com.bank.cashMachine.infrastructure.controller.BanknotesResponse;
import com.bank.cashMachine.infrastructure.controller.DataResponse;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class DataResponseMapperTest {

    @Test
    public void testToDataResponse() {
        DataResponseMapper mapper = new DataResponseMapper();
        List<BanknotesResponse> banknotesResponses = new ArrayList<>();
        banknotesResponses.add(new BanknotesResponse(10, 5));
        banknotesResponses.add(new BanknotesResponse(20, 3));
        String message = "Success";

        DataResponse dataResponse = mapper.toDataResponse(banknotesResponses, message);

        assertNotNull(dataResponse);
        assertEquals(banknotesResponses, dataResponse.data());
        assertEquals(message, dataResponse.message());
    }
}