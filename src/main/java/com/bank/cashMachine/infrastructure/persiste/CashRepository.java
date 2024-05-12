package com.bank.cashMachine.infrastructure.persiste;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashRepository {
    List<CashEntity> searchCash();
    void updateCash(Integer id, Integer quantity);
}
