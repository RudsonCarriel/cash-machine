package com.bank.cashMachine.infrastructure.persiste.queries;

public class CashParametersQueries {

    public static final String SEARCH_CASH = """ 
            SELECT * FROM "CXR".nota ORDER BY "VALOR_NOTA" DESC;""";

    public static final String UPDATE_CASH = """ 
            UPDATE "CXR".nota SET "QT_DISPONIVEL"=:quantity WHERE "ID"=:id;""";
}
