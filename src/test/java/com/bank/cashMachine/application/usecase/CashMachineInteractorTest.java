package com.bank.cashMachine.application.usecase;

import static org.junit.jupiter.api.Assertions.*;

import com.bank.cashMachine.application.gateways.CashGateway;
import com.bank.cashMachine.domain.entity.Cash;
import com.bank.cashMachine.infrastructure.controller.DataResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.*;

public class CashMachineInteractorTest {

    private CashMachineInteractor cashMachineInteractor;

    @Mock
    private CashGateway cashGateway;

    @Mock
    private DataResponseMapper mapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cashMachineInteractor = new CashMachineInteractor(cashGateway, mapper);
    }

    @Test
    public void testSearchCash() {
        List<Cash> mockCashList = List.of(new Cash(1 ,1, 1));
        when(cashGateway.searchCash()).thenReturn(mockCashList);

        List<Cash> result = cashMachineInteractor.searchCash();

        assertEquals(mockCashList, result);
    }

    @Test
    public void testUpdateCash() {
        Map<Integer, Integer> banknotes = new HashMap<>();

        cashMachineInteractor.updateCash(banknotes);

        verify(cashGateway, times(banknotes.size())).updateCash(anyInt(), anyInt());
    }

    @Test
    public void testWithdrawCashUnsuccessful() {

        when(cashGateway.searchCash()).thenReturn(Collections.emptyList());

        DataResponseMapper mapper = mock(DataResponseMapper.class);

        when(mapper.toDataResponse(anyList(), anyString())).thenReturn(DataResponse.builder().data(Collections.emptyList()).message("DESCULPE, NÃO FOI POSSÍVEL SACAR O VALOR DESEJADO!!!").build());
        CashMachineInteractor cashMachineInteractor = new CashMachineInteractor(cashGateway, mapper);
        DataResponse result = cashMachineInteractor.withdrawCash(100);

        assertEquals("DESCULPE, NÃO FOI POSSÍVEL SACAR O VALOR DESEJADO!!!", result.message());

        assertTrue(result.data().isEmpty());
    }

    @Test
    public void testWithdrawCash() {
        when(cashGateway.searchCash()).thenReturn(Collections.emptyList());

        DataResponseMapper mapper = mock(DataResponseMapper.class);

        when(mapper.toDataResponse(anyList(), anyString())).thenReturn(DataResponse.builder().data(Collections.emptyList()).message("SAQUE REALIZADO COM SUCESSO!!!").build());
        CashMachineInteractor cashMachineInteractor = new CashMachineInteractor(cashGateway, mapper);
        DataResponse result = cashMachineInteractor.withdrawCash(100);

        assertEquals("SAQUE REALIZADO COM SUCESSO!!!", result.message());

    }
}