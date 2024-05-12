package com.bank.cashMachine.infrastructure.persiste;


import com.bank.cashMachine.infrastructure.persiste.queries.CashParametersQueries;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.bank.cashMachine.application.usecase.exceptions.DatabaseException;
import com.bank.cashMachine.application.usecase.exceptions.NotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CashRepositoryImpl implements CashRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String ID_CASH = "id";

    private static final String QUANTITY = "quantity";

    private static final String ERROR_TAMPLETE = "SQL:\n%s";

    @Override
    public List<CashEntity> searchCash() {
        try {
            return jdbcTemplate.query(CashParametersQueries.SEARCH_CASH, DataClassRowMapper.newInstance(CashEntity.class));
        } catch (EmptyResultDataAccessException e){
            log.error(String.format(ERROR_TAMPLETE, CashParametersQueries.SEARCH_CASH));
            throw new NotFoundException(CashParametersQueries.SEARCH_CASH);
        } catch (DataAccessException e){
            log.error(String.format(ERROR_TAMPLETE, CashParametersQueries.SEARCH_CASH));
            throw new DatabaseException("ERROR search cash", e);
        }

    }

    @Override
    public void updateCash(Integer id, Integer quantity) {
        final var param = new MapSqlParameterSource()
                .addValue(ID_CASH, id)
                .addValue(QUANTITY, quantity);
        try {
            final var n = jdbcTemplate.update(CashParametersQueries.UPDATE_CASH, param);
            if(n < 1){
                throw new NotFoundException(String.format("ERRO ao alterar notas, nao encontrado o id %d.",id));
            }
        } catch (DataAccessException e){
            log.error(String.format(ERROR_TAMPLETE, CashParametersQueries.UPDATE_CASH));
            throw new DatabaseException("ERRO ao alterar notas", e);
        }
    }


}
