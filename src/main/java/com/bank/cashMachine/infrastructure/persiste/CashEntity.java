package com.bank.cashMachine.infrastructure.persiste;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("NOTA")
public record CashEntity(@Id Integer id, Integer valor_nota, Integer qt_disponivel) {
}
