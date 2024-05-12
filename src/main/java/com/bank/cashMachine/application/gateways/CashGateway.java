package com.bank.cashMachine.application.gateways;

import com.bank.cashMachine.domain.entity.Cash;

import java.util.List;

public interface CashGateway {
  List<Cash> searchCash();
  void updateCash(Integer id, Integer quantity);
}
