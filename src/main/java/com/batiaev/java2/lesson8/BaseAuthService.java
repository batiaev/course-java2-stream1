package com.batiaev.java2.lesson8;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseAuthService
 *
 * @author anton
 * @since 06/11/17
 */
public class BaseAuthService implements AuthService {
    private class Entry {
        private String login;
        private String password;
        private String nick;

        public Entry(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getNick() {
            return nick;
        }
    }

    private List<Entry> entries;
    private Connection conn;

    private final String DB_PATH = "C:\\dev\\java\\desktop\\coursejava2\\users.db";


    public BaseAuthService() {
        init();
    }

    public int init() {

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(JDBC.PREFIX + DB_PATH);
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute("CREATE TABLE IF NOT EXISTS users (login VARCHAR (50) UNIQUE NOT NULL PRIMARY KEY, password VARCHAR (250), nick VARCHAR (250) UNIQUE NOT NULL)");
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        entries = new ArrayList<>();
        entries.add(new Entry("login1", "pass1", "nick1"));
        entries.add(new Entry("login2", "pass2", "nick2"));
        entries.add(new Entry("login3", "pass3", "nick3"));
        return entries.size();
    }

    @Override
    public String getNick(String login, String pass) {
        for (Entry e : entries) {
            if (e.getLogin().equals(login) && e.getPassword().equals(pass)) return e.getNick();
        }
        return null;
    }

    @Override
    public boolean login(String login, String pass) {
        for (Entry e : entries) {
            if (e.getLogin().equals(login) && e.getPassword().equals(pass)) return true;
        }
        return false;
    }

    @Override
    public boolean contains(String userName) {
        if (userName == null || userName.trim().isEmpty()) return false;

        for (Entry e : entries) {
            if (userName.equals(e.getNick())) return true;
        }
        return false;
    }
}
