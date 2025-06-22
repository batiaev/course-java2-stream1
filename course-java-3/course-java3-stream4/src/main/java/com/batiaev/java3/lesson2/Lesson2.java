package com.batiaev.java3.lesson2;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * Lesson2
 *
 * @author anton
 * @since 22/08/19
 */
public class Lesson2 {
    private static final String DB_PATH = "/Users/anton/lesson2.db";

    public static void main(String[] args) throws SQLException {
        Set<Student> students = loadStudents();
        saveStudents(students);
        System.out.println(loadStudents());
    }

    private static void saveStudents(Set<Student> students) throws SQLException {

        Connection conn = DriverManager.getConnection(JDBC.PREFIX + DB_PATH);
        PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO Students (Name, GroupName, Score)" +
                        "VALUES (?, ?, ?);");
        for (Student student : students) {
            String uuid = UUID.randomUUID().toString();
            Random random = new Random();
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getGroup()+"1");
            preparedStatement.setInt(3, student.getScore());
            preparedStatement.addBatch();
            preparedStatement.clearParameters();
        }
        int result = preparedStatement.executeUpdate();
    }

    public static Set<Student> loadStudents() {

        Set<Student> students = new HashSet<>();
        Connection conn;
        try {
            conn = DriverManager.getConnection(JDBC.PREFIX + DB_PATH);
            Statement stmt = conn.createStatement();
            conn.commit();
//            boolean execute = stmt.execute("CREATE TABLE Students (\n" +
//                    "    Name varchar(255),\n" +
//                    "    GroupName varchar(255),\n" +
//                    "    Score int\n" +
//                    ");");
//            System.out.println(execute);

//            String uuid = UUID.randomUUID().toString();
//            int result = stmt.executeUpdate(
//                    "INSERT INTO Students (Name, GroupName, Score)" +
//                        " VALUES (\"" + uuid + "\", \"group2\", 35);");
//            System.out.println(result);

            ResultSet resultSet = stmt.executeQuery("SELECT * from Students");
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String group = resultSet.getString("GroupName");
                int score = resultSet.getInt("Score");
                students.add(new Student(name,group,score));
            }
//            result = stmt.executeUpdate("UPDATE Students SET Name = 'Clark1' WHERE Name = 'Bob1'");
//            System.out.println(result);

//            result = stmt.executeUpdate("DELETE FROM Students WHERE Name = '"+uuid+"'");
//            System.out.println(result);
//            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}