package com.batiaev.java3.lesson2.homework;

import java.sql.*;

public class Db {

    private Connection connect;
    private Statement stmt;

    private static final String DB_NAME = "product.db";

    public Db() {
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
            stmt = connect.createStatement();
            clearTable();
            insertData();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clearTable() {
        try {
            stmt.executeUpdate("DELETE FROM product;");
            System.out.println("Очистили таблицу product");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData() {
        try {
            connect.setAutoCommit(false);
            PreparedStatement ps = connect.prepareStatement(
                    "INSERT INTO product VALUES (?,?,?,?);");
            for (int i = 1; i <= 10000; i++) {
                ps.setInt(1, i);
                ps.setInt(2, i);
                ps.setString(3, "товар" + i);
                ps.setDouble(4, i);
                ps.addBatch();
            }
            ps.executeBatch();
            connect.commit();
            System.out.println("Вставили 10000 строк");
        } catch (SQLException e) {
            try {
                connect.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    void close() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void updatePrice(String product_id, String new_price) {
        String query = String.format(
                "UPDATE product SET cost = %s WHERE title = '%s';",
                new_price, product_id);
        System.out.println(query);
        try {
            Integer result = stmt.executeUpdate(query);
            if (result > 0) {
                connect.commit();
                System.out.println("Затронуто строк: " + result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void getProduct(String str) {
        String query = String.format(
                "SELECT cost FROM product WHERE title = '%s';", str);
        try {
            ResultSet result = stmt.executeQuery(query);
            if (result != null) {
                System.out.println("Цена товара " + result.getString("cost"));
            }

        } catch (SQLException e) {
            System.out.println("Такого товара нет");
            e.printStackTrace();
        }
    }

    void getProductsByCost(String min, String max) {
        String query = String.format(
                "SELECT title FROM product WHERE cost BETWEEN %s AND %s ;", min, max);
        try {
            ResultSet result = stmt.executeQuery(query);
            if (result != null) {
                while (result.next()) {
                    System.out.println(result.getString("title"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Такого товара нет");
            e.printStackTrace();
        }
    }

}