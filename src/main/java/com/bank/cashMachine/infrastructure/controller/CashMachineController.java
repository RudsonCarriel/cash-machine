package com.bank.cashMachine.infrastructure.controller;

import com.bank.cashMachine.application.usecase.CashMachineUserCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cashMachine")
@RequiredArgsConstructor
public class CashMachineController {

    private final CashMachineUserCase service;

    @PostMapping("/withdraw")
    public ResponseEntity<DataResponse> withdraw(@Valid @RequestBody LootRequest lootRequest ) throws BadRequestException {
        BigDecimal bd = BigDecimal.valueOf(lootRequest.value());
        if (bd.scale() > 0 && bd.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) != 0) {
            throw new BadRequestException();
        }
        return ResponseEntity.ok(service.withdrawCash(lootRequest.value().intValue()));
    }
}