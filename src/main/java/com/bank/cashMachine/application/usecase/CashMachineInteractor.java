package com.bank.cashMachine.application.usecase;

import com.bank.cashMachine.application.gateways.CashGateway;
import com.bank.cashMachine.infrastructure.controller.BanknotesResponse;
import com.bank.cashMachine.infrastructure.controller.DataResponse;
import com.bank.cashMachine.domain.entity.Cash;

import java.util.*;

import static java.util.Collections.emptyList;


public class CashMachineInteractor implements CashMachineUserCase {

  private final CashGateway cashGateway;
  private final DataResponseMapper mapper;

    public CashMachineInteractor(CashGateway cashGateway, DataResponseMapper mapper) {
        this.cashGateway = cashGateway;
        this.mapper = mapper;
    }


    @Override
  public List<Cash> searchCash() {
     return cashGateway.searchCash();
  }

  @Override
  public void updateCash(Map<Integer, Integer> banknotes) {
      for (Map.Entry<Integer, Integer> entry : banknotes.entrySet()) {
        cashGateway.updateCash(entry.getKey(),entry.getValue());
      }
    }

  @Override
  public DataResponse withdrawCash(Integer value) {
      Map<Integer, Integer> noteWithdrawn = new HashMap<>();
      List<BanknotesResponse> banknotesList = new ArrayList<>();

      for (Cash cash : searchCash()) {
          if (value >= cash.valor_nota() && cash.qt_disponivel() > 0) {
              var availableNotes = Math.min(cash.qt_disponivel(), value / cash.valor_nota());
              noteWithdrawn.put(cash.id(), cash.qt_disponivel() - availableNotes);
              banknotesList.add(new BanknotesResponse(cash.valor_nota(), availableNotes));
              value -= cash.valor_nota() * availableNotes;
          }
      }
      if (value > 0) {
          return mapper.toDataResponse(emptyList() , "DESCULPE, NÃO FOI POSSÍVEL SACAR O VALOR DESEJADO!!!");
      } else {
          updateCash(noteWithdrawn);
          return mapper.toDataResponse(banknotesList, "SAQUE REALIZADO COM SUCESSO!!!");
      }

    }

}
