package com.bank.cashMachine.application.usecase;

import com.bank.cashMachine.infrastructure.controller.BanknotesResponse;
import com.bank.cashMachine.infrastructure.controller.DataResponse;

import java.util.List;

public class DataResponseMapper {

    DataResponse toDataResponse(List<BanknotesResponse> responses, String message) {
        return  new DataResponse(responses, message);

    }
}
