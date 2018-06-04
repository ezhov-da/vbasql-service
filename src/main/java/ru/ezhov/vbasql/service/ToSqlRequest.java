package ru.ezhov.vbasql.service;

public class ToSqlRequest {
    private boolean addADODB;
    private boolean useConnectionString;
    private boolean addExecuteADODB;
    private String connectionString;
    private String variable;
    private String query;

    public ToSqlRequest() {
    }

    public ToSqlRequest(
            boolean addADODB,
            boolean useConnectionString,
            boolean addExecuteADODB,
            String connectionString,
            String variable,
            String query) {
        this.addADODB = addADODB;
        this.useConnectionString = useConnectionString;
        this.addExecuteADODB = addExecuteADODB;
        this.connectionString = connectionString;
        this.variable = variable;
        this.query = query;
    }

    public boolean getAddADODB() {
        return addADODB;
    }

    public void setAddADODB(boolean addADODB) {
        this.addADODB = addADODB;
    }

    public boolean getUseConnectionString() {
        return useConnectionString;
    }

    public void setUseConnectionString(boolean useConnectionString) {
        this.useConnectionString = useConnectionString;
    }

    public boolean getAddExecuteADODB() {
        return addExecuteADODB;
    }

    public void setAddExecuteADODB(boolean addExecuteADODB) {
        this.addExecuteADODB = addExecuteADODB;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "ToSqlRequest{" +
                "addADODB='" + addADODB + '\'' +
                ", useConnectionString='" + useConnectionString + '\'' +
                ", addExecuteADODB='" + addExecuteADODB + '\'' +
                ", connectionString='" + connectionString + '\'' +
                ", variable='" + variable + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}
