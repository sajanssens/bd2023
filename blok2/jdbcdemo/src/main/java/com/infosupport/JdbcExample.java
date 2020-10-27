package com.infosupport;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // 1
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // Not needed anymore since Java 6 (JDBC4)
        // "Java6 (and JDBC4) introduced a concept known as "service provider" where implementations of known interface can be detected by the JVM during startup."
        // https://stackoverflow.com/questions/28220724/class-fornamejdbc-driver-no-longer-needed

        // 2
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");

        // 3
        Statement statement = connection.createStatement();

        // 4
        ResultSet result = statement.executeQuery("SELECT * FROM PERSON");

        // 5
        while (result.next()) {
            String name = result.getString("name");
            int age = result.getInt("age");

            System.out.println(name + " - " + age);
        }

        // 6
        statement.close();
        connection.close();
    }
}
