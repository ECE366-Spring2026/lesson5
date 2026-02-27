package com.ece366.rps.util;

import java.sql.Connection;

public abstract class DataAccessObject <T extends DataTransferObject> {

    protected final Connection connection;
    protected final static String LAST_VAL = "SELECT last_value FROM ";

    public DataAccessObject(Connection connection){
        super();
        this.connection = connection;
    }

    public abstract T findById(String id);
    public abstract T create(T dto);
    public abstract T update(T dto);
    public abstract T delete(T dto);
}