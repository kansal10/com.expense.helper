package com.expense.helper.rest.internal.db;

import java.sql.Connection;

import org.sqlite.SQLiteDataSource;

/**
 * Connection to connect to the database.
 * 
 * @author Prateek Kansal
 */
public class ExpenseHelperDBConnection
{

    private static final String LOCAL_DATABSE_FILE_URL = "C://sqlite/expensehelper.db";

    /**
     * @return The database connection. This value will never be {@code null}.
     */
    public static Connection getConnection()
    {
        return createConnection();
    }

    private ExpenseHelperDBConnection()
    {
    }

    private static Connection createConnection()
    {
        try
        {
            SQLiteDataSource dataSource = new SQLiteDataSource();

            dataSource.setUrl("jdbc:sqlite:" + LOCAL_DATABSE_FILE_URL);

            return dataSource.getConnection();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    // String DATASOURCE_CONTEXT = "java:comp/env/jdbc/blah";
    //
    // Connection result = null;
    // try {
    // DataSource datasource =
    // (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
    // if (datasource != null) {
    // result = datasource.getConnection();
    // }
    // else {
    // log("Failed to lookup datasource.");
    // }
    // }
    // catch ( NamingException ex ) {
    // log("Cannot get connection: " + ex);
    // }
    // catch(SQLException ex){
    // log("Cannot get connection: " + ex);
    // }
    // return result;
}
