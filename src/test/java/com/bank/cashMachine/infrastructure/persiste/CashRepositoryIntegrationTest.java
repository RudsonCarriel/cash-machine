package com.bank.cashMachine.infrastructure.persiste;

import static org.junit.jupiter.api.Assertions.*;

import com.bank.cashMachine.infrastructure.persiste.queries.CashParametersQueries;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CashRepositoryIntegrationTest {

    @Autowired
    private CashRepository cashRepository;

    @Test
    @Sql(statements = {
            CashParametersQueries.SEARCH_CASH
    })
    public void testSearchCash() {
        List<CashEntity> cashEntities = cashRepository.searchCash();

        assertNotNull(cashEntities);
        assertFalse(cashEntities.isEmpty());
    }
}