package com.bank.cashMachine.infrastructure.controller;


import jakarta.validation.constraints.Min;

public record LootRequest(@Min(value = 1) Double value) {
}
