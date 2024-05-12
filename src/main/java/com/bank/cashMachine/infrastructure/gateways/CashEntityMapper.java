package com.bank.cashMachine.infrastructure.gateways;


import com.bank.cashMachine.domain.entity.Cash;
import com.bank.cashMachine.infrastructure.persiste.CashEntity;

import java.util.List;

public class CashEntityMapper {

    List<Cash> toDomainObj(List<CashEntity> cashEntity) {
         return  cashEntity.stream().map(c -> new Cash(c.id(),c.valor_nota(),c.qt_disponivel())).toList();

    }
}
