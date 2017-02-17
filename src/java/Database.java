package pkdatabase;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Configurable class to implement a database connection
 * Could be made to implement an interface, but that does not seem necessary at this time
 *
 * @author Peter Knibbe
 * @since December 8, 2016
 */
public class Database {

    private java.sql.Connection connection;
    private Properties properties;

    /**
     * default constructor
     */
    public Database() {
        loadProperties();
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioe) {
            System.out.println("Database.loadProperties()...Cannot load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Database.loadProperties()..." + e);
            e.printStackTrace();
        }

    }

    /**
     * make connection to database
     */
    public void connect () {

        if (connection == null) {

            try {
                Class.forName(properties.getProperty("driver"));
            } catch (ClassNotFoundException e) {
                System.err.println("PWK:Database Error in finding driver " + e);
                e.printStackTrace();
                return;
            }

            try {
                connection = DriverManager.getConnection(properties.getProperty("url"),
                        properties.getProperty("username"),
                        properties.getProperty("password"));
            } catch (SQLException sqlException) {
                System.err.println("PWK:Database Error in connecting to database " + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("PWK:Database General Error");
                exception.printStackTrace();
            }
        }
    }

    /**
     * disconnect from database
     */
    public void disconnect() {

        try {
        connection.close();
        } catch (SQLException sqlException) {
            System.err.println("PWK:Database Error in disconnecting from database " + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("PWK:Database General Error");
            exception.printStackTrace();
        } finally {
            connection = null;
        }
    }

    /**
     * query the database
     * @param preparedStatement The query to use
     * @param closeWhenDone Whether to disconnect from the database
     * @return resultSet The query results
     */
    public ResultSet query(String queryString) {
        ResultSet resultSet = null;

        connect();
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                System.out.println("PWK:Database executing " + queryString);
                resultSet = statement.executeQuery(queryString);
            }
            else {
                System.out.println("PWK:Database connection is null");
            }
        } catch (SQLException sqlException) {
            System.err.println("PWK:Database Error in connecting to database " + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("PWK:Database General Error");
            exception.printStackTrace();
        } finally {
            return resultSet;
        }
    }

    /**
     * update the database
     * @param PreparedStatement The update to use
     * @param closeWhenDone Whether to disconnect from the database
     * @return The number of updated table rows
     */
    public int update(String updateString) {
        int result = 0;

        connect();
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                result = statement.executeUpdate(updateString);
            }
        } catch (SQLException sqlException) {
            System.err.println(java.text.MessageFormat.format("PWK:Database Error in connecting to database {0}", sqlException));
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("PWK:Database General Error");
            exception.printStackTrace();
        } finally {
            return result;
        }
    }
}

