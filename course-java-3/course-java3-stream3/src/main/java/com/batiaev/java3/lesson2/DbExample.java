package com.batiaev.java3.lesson2;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.UUID;

public class DbExample {
    private static final String DB_PATH = "/Users/anton/Documents/_repo/_github/batiaev/courses/java3-stream3/src/main/resources/lesson2.db";

    private static void mysql() {
        String url = "jdbc:mysql://localhost:3306/lesson2";
        String username = "root";
        String password = "qwe123";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);




            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
//            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection(JDBC.PREFIX + DB_PATH);

//            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            PreparedStatement preparedStatement =
                    conn.prepareStatement("select * from Students");
            preparedStatement.addBatch();

        //    CallableStatement callableStatement =
        //            conn.prepareCall("EXEC my_procedure();");
        //    callableStatement.setBlob();
        //    callableStatement.execute();

            //insert
            String uuid = UUID.randomUUID().toString();
            int result = stmt.executeUpdate("INSERT INTO Students (Name, GroupName, Score) VALUES (\""
                    + uuid + "\", \"group2\", 40);");


//            System.out.println(result);
            //select
            ResultSet resultSet = stmt.executeQuery("select * from Students");
            while (resultSet.next()) {
                int name = resultSet.findColumn("Name");
                String string = resultSet.getString(name);
                System.out.println("Name:" + string);
            }

//            result = stmt.executeUpdate("UPDATE Students SET Name = 'Clark1' WHERE Name = 'Bob1'");
//            System.out.println(result);

//            result = stmt.executeUpdate("DELETE FROM Students WHERE Name = '"+uuid+"'");
//            System.out.println(result);
//            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
