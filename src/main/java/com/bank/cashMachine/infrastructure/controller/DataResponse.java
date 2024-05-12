package com.bank.cashMachine.infrastructure.controller;

import lombok.Builder;

import java.util.List;
@Builder
public record DataResponse(List<BanknotesResponse> data,
                           String message) {
}
