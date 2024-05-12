package com.bank.cashMachine.application.usecase;

import com.bank.cashMachine.infrastructure.controller.DataResponse;
import com.bank.cashMachine.domain.entity.Cash;

import java.util.List;
import java.util.Map;

public interface CashMachineUserCase {
  List<Cash> searchCash();
  void updateCash(Map<Integer, Integer> banknotes);
  DataResponse withdrawCash(Integer value);
}
