package com.batiaev.java3.lesson6.homework;

import lombok.extern.java.Log;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@Log
public class Task3 {
    private Connection connection;
    private Statement statement;
    private final static String SELECT_ALL = "SELECT * FROM students ";

    @Before
    public void setUp() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(JDBC.PREFIX + "src/main/resources/Lesson6.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        Homework6.connect();
    }

    @After
    public void tearDown() {
        Homework6.disconnect();
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        try {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            //количество записей в таблице до проведения операции вставки
            int numOfLineBefore = 0;
            while (resultSet.next()) {
                numOfLineBefore = resultSet.getRow();
            }
            log.info("Количество записей до вставки: " + numOfLineBefore);

            //тестируем метод
            Homework6.insert("Test", 0);

            //количество записей в таблице после проведения операции вставки
            resultSet = statement.executeQuery(SELECT_ALL);
            int numOfLineAfter = 0;
            while (resultSet.next()) {
                numOfLineAfter = resultSet.getRow();
                //удаляем запись, которая появилась в таблице после тестирования
            }
            statement.executeUpdate("DELETE FROM students WHERE surname = 'Test'");
            log.info("Количество записей после вставки: " + numOfLineAfter);

            assertEquals("количество записей после вставки, должно увеличиться на 1 запись",
                    numOfLineAfter, (numOfLineBefore + 1));

            resultSet = statement.executeQuery(SELECT_ALL);
            int rowAfterTest = 0;
            while (resultSet.next()) {
                rowAfterTest = resultSet.getRow();
            }
            log.info("Количество записей после тестирования " + rowAfterTest);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        try {
            Homework6.insert("Test", 0); //создаем тестовую запись

            int oldPoints = 0;
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                if (resultSet.getString("surname").equals("Test")) {
                    //Запоминаем количество баллов которое было у Test
                    oldPoints = resultSet.getInt("points");
                }
            }
            log.info("Количество баллов у Test до изменения: " + oldPoints);

            Homework6.update("Test", 10); //тестируем метод update()

            int newPoints = 0;
            resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                if (resultSet.getString("surname").equals("Test")) {
                    //Запоминаем количество баллов у Test после внесения изменений
                    newPoints = resultSet.getInt("points");
                }
            }
            log.info("Количество баллов у Test после изменения: " + newPoints);

            //проверяем, что изменения были внесены
            assertNotEquals("должны быть внесены изменения в поле с баллами", oldPoints, newPoints);

            Homework6.delete("Test"); //удаляем тестовую запись
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void read() {
        try {
            Homework6.insert("Test", 0); //создаем тестовую запись
            //тестируем метод read()
            ArrayList<String> dataBaseList = new ArrayList<>(Homework6.read(0));

            //запрашиваем из базы всех учеников с кол-вом баллов равных 0
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            ArrayList<String> testList = new ArrayList<String>();
            while (resultSet.next()) {
                if (resultSet.getInt("points") == 0) {
                    testList.add(resultSet.getString("surname"));
                    log.info("Тестовая запись присутствует: " + resultSet.getString("surname"));
                }
            }

            //проверяем сработал ли метод read() корректно
            Collections.sort(dataBaseList);
            Collections.sort(testList);
            assertEquals(dataBaseList, testList);

            Homework6.delete("Test"); //удаляем тестовую запись

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        try {
            Homework6.insert("Test", 0); //создаем тестовую запись

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                if (resultSet.getString("surname").equals("Test")) {
                    log.info("Тестовая запись присутствует: " + resultSet.getString("surname"));
                }
            }

            Homework6.delete("Test");

            resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                assertNotEquals("Записи Test не должно существовать",
                        resultSet.getString("surname"), ("Test"));
            }

            resultSet = statement.executeQuery(SELECT_ALL + " WHERE surname = 'Test'");
            if (!resultSet.next()) {//метод next должен возвратить false если в resultSet нет соответствующей записи
                log.info("Тестовая запись удалена");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}