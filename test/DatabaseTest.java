package java112.utilities;

import java.sql.*;
import java.util.*;

public class DatabaseTest {
    private boolean passed;
    Database database;

    /**
     * constructor
     */
    DatabaseTest(Properties properties){
        passed = true;
        database=new Database(properties);
        runTest();
    }

    /**
     * Note failure of test
     */
    private void FailTest() {
        passed = false;
    }

    /**
     * Gets the current test status (pass or fail)
     *
     * @return passed Whether the test is currently passing
     */
    private boolean getStatus() {
        return passed;
    }

    /**
     * Main test method that calls the component tests for the Database class
     */
    private void runTest(){
        boolean passed=true;
        database.connect();
        insertMichael();
        findMichael();
        deleteMichael();
    }

    /**
     * Insert Mike Schmidt as employee
     */
    private void insertMichael() {
        int rowsAffected;
        String updateString =  "INSERT INTO employees (first_name, last_name, ssn, dept,"
        + " room, phone) VALUES (\"Michael\", \"Schmidt\", \"192837456\", \"Infield\", \"3rd\", \"1928374\")";
        rowsAffected = database.update(updateString);
        if (rowsAffected != 1) {
            passed = false;
            System.out.println("While Adding Mike Schmidt expected one affected row, got " + rowsAffected);
        }
    }

    /**
     * Find Mike Schmidt as employee
     */
    private void findMichael() {
        ResultSet resultSet;
        String queryString =  "SELECT * FROM employees WHERE last_name=\"Schmidt\"";
        resultSet = database.query(queryString);

        System.out.println("While seeking Mike Schmidt found");

        try {
            while (resultSet.next()) {
                String employeeId = resultSet.getString("emp_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(" Row: " + employeeId + " "
                        + firstName + " " + lastName);
            }
        } catch (SQLException sqlException) {
            System.err.println(java.text.MessageFormat.format("Error in connecting to database {0}", sqlException));
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }

        System.out.println();

    }

    /**
     * Remove Mike Schmidt as employee
     */
    private void deleteMichael() {
        int rowsAffected;
        String updateString = "DELETE FROM employees WHERE last_name=\"Schmidt\"";
        rowsAffected = database.update(updateString);
        if (rowsAffected != 1) {
            passed = false;
            System.out.println("While removing Mike Schmidt expected one affected row, got " + rowsAffected);
        }
    }
}