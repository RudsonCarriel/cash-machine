package com.bank.cashMachine.infrastructure.gateways;

import com.bank.cashMachine.application.gateways.CashGateway;
import com.bank.cashMachine.domain.entity.Cash;
import com.bank.cashMachine.infrastructure.persiste.CashRepository;

import java.util.List;

public class CashRepositoryGateway implements CashGateway {
    private final CashRepository cashRepository;
    private final CashEntityMapper mapper;

    public CashRepositoryGateway(CashRepository cashRepository, CashEntityMapper mapper) {
        this.cashRepository = cashRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Cash> searchCash() {
        return mapper.toDomainObj(cashRepository.searchCash());
    }

    @Override
    public void updateCash(Integer id, Integer quantity) {
        cashRepository.updateCash(id, quantity);
    }
}
