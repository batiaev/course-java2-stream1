package com.batiaev.java3.lesson6.homework;

import lombok.extern.java.Log;
import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log
public class Homework6 {
    private Connection conn;
    private Statement stmt;

    public void createDb() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = conn.createStatement();

            stmt.execute("DROP TABLE IF EXISTS students;");
            stmt.execute("CREATE TABLE students (id INT PRIMARY KEY, surname VARCHAR(50), score INT);");

            stmt.execute("INSERT INTO students VALUES (1, 'Иванов', 10);");
            stmt.execute("INSERT INTO students VALUES (2, 'Петров', 20);");
            stmt.execute("INSERT INTO students VALUES (3, 'Сидоров', 30);");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int[] task1(int[] arrIn) {
        int[] backArr = new int[2];
        if (arrIn.length == 0) {
            log.info("В массиве нет элементов");
            return arrIn;
        }
        //начинаем поиск "4" с третьего элемента с конца, если "4" окажется последней или предпоследней, то после неё
        //не будет необходимых двух чисел для составления возвращаемого массива
        for (int i = arrIn.length - 3; i >= 0; i--) {
            if (arrIn[i] == 4) {
                System.arraycopy(arrIn, (i + 1), backArr, 0, 2);
                return backArr;
            }
        }
        throw new RuntimeException("В массиве нет ни одной четверки, после которой есть два числа");
    }

    public static boolean task2(int[] arrIn) {
        boolean one = false;
        boolean four = false;
        for (int i : arrIn) {
            if (i != 1 && i != 4) return false;
            if (i == 1) one = true;
            if (i == 4) four = true;
        }
        return (one && four);
    }

    //Task3
    private static Connection connection;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(JDBC.PREFIX + "main.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String surname, int points) {
        String insertSQL = "INSERT INTO students (surname, points) VALUES (?, ?)";
        PreparedStatement preparedStatementInsert = null;
        try {
            preparedStatementInsert = connection.prepareStatement(insertSQL);
            preparedStatementInsert.setString(1, surname);
            preparedStatementInsert.setInt(2, points);
            preparedStatementInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatementInsert != null) {
                    preparedStatementInsert.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(String surname, int points) {
        String updateSQL = "UPDATE students SET points = ? WHERE surname = ?";
        PreparedStatement preparedStatementUpdate = null;
        try {
            preparedStatementUpdate = connection.prepareStatement(updateSQL);
            preparedStatementUpdate.setInt(1, points);
            preparedStatementUpdate.setString(2, surname);
            preparedStatementUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatementUpdate != null) {
                    preparedStatementUpdate.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //получаем список студентов, с заданным кол-вом баллов
    public static List<String> read(int points) {
        ArrayList<String> students = new ArrayList<String>();
        String readSQL = "SELECT * FROM students";
        Statement statementRead = null;
        try {
            statementRead = connection.createStatement();
            ResultSet resultSet = statementRead.executeQuery(readSQL);
            while (resultSet.next()) {
                if (resultSet.getInt("points") == points) {
                    students.add(resultSet.getString("surname"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statementRead != null)
                    statementRead.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public static void delete(String surname) {
        String updateSQL = "DELETE FROM students WHERE surname = ?";
        PreparedStatement preparedStatementUpdate = null;
        try {
            preparedStatementUpdate = connection.prepareStatement(updateSQL);
            preparedStatementUpdate.setString(1, surname);
            preparedStatementUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatementUpdate != null) {
                    preparedStatementUpdate.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
