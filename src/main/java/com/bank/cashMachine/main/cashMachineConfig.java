package com.bank.cashMachine.main;

import com.bank.cashMachine.application.gateways.CashGateway;
import com.bank.cashMachine.application.usecase.CashMachineInteractor;
import com.bank.cashMachine.application.usecase.CashMachineUserCase;
import com.bank.cashMachine.application.usecase.DataResponseMapper;
import com.bank.cashMachine.infrastructure.gateways.CashEntityMapper;
import com.bank.cashMachine.infrastructure.gateways.CashRepositoryGateway;
import com.bank.cashMachine.infrastructure.persiste.CashRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class cashMachineConfig {
    @Bean
    CashMachineUserCase cashMachineInteractor (CashGateway cashGateway, DataResponseMapper mapper) {
        return new CashMachineInteractor(cashGateway, mapper);
    }

    @Bean
    CashGateway cashGateway(CashRepository cashRepository, CashEntityMapper mapper) {
        return new CashRepositoryGateway(cashRepository, mapper);
    }

    @Bean
    CashEntityMapper cashEntityMapper() {
        return new CashEntityMapper();
    }
    @Bean
    DataResponseMapper toDataResponse() {
        return new DataResponseMapper();
    }
}
