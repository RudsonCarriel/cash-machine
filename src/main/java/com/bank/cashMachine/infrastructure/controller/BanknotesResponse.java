package com.bank.cashMachine.infrastructure.controller;

import lombok.Builder;

@Builder
public record BanknotesResponse(
        Integer cash,
        Integer quantity) {
}
