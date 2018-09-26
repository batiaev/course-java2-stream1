package com.batiaev.java2.lesson8;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseAuthService
 *
 * @author anton
 * @since 06/11/17
 */
public class BaseAuthService implements AuthService {

    private final String DB_PATH = "C:\\dev\\java\\desktop\\coursejava2\\users.db";
    private List<Entry> entries;
    private Connection conn;
    private PreparedStatement addUserStatement;
    private PreparedStatement selectUsersStatement;
    private PreparedStatement updateNickStatement;
    private PreparedStatement updatePasswordStatement;
    private PreparedStatement deleteUserStatement;

    public BaseAuthService() {
        init();
    }

    public void init() {

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(JDBC.PREFIX + DB_PATH);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS users (login VARCHAR (50) UNIQUE NOT NULL PRIMARY KEY, password VARCHAR (250), nick VARCHAR (250) UNIQUE NOT NULL)");

            selectUsersStatement = conn.prepareStatement("SELECT login, password, nick FROM USERS");
            addUserStatement = conn.prepareStatement("INSERT INTO USERS (login,password,nick) VALUES(?,?,?)");
            updateNickStatement = conn.prepareStatement("update USERS SET nick = ? WHERE login = ?");
            updatePasswordStatement = conn.prepareStatement("update USERS SET password = ? WHERE login = ?");
            deleteUserStatement = conn.prepareStatement("DELETE FROM USERS WHERE login=?");

            loadUsersFromDB();

            if (entries.size() == 0) {
                for (int i = 0; i < 3; i++) {
                    addLogin("login" + i, "pass" + i, "nick" + i);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addLogin(String login, String password, String nick) {
        if (!contains(nick) && !containsLogin(login)) {
            Entry entry = new Entry(login, password, nick);
            try {
                addUserStatement.setString(1, login);
                addUserStatement.setString(2, password);
                addUserStatement.setString(3, nick);
                addUserStatement.execute();
                entries.add(entry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteUser(String login) {
        try {
            for (Entry entry : entries) {
                if (entry.getLogin().equals(login)) {
                    deleteUserStatement.setString(1, login);
                    deleteUserStatement.execute();
                    entries.remove(entry);
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updatePassword(String login, String password) {
        try {
            for (Entry entry : entries) {
                if (entry.getLogin().equals(login)) {
                    updatePasswordStatement.setString(1, password);
                    updatePasswordStatement.setString(2, login);
                    updatePasswordStatement.execute();
                    entry.setPassword(password);
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeNick(String login, String nick) {
        try {
            for (Entry entry : entries) {
                if (entry.getLogin().equals(login)) {
                    updateNickStatement.setString(1, nick);
                    updateNickStatement.setString(2, login);
                    updateNickStatement.execute();
                    entry.setNick(nick);
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public boolean contains(String nick) {
        if (nick == null || nick.trim().isEmpty()) return false;

        for (Entry e : entries) {
            if (nick.equals(e.getNick())) return true;
        }
        return false;
    }

    private boolean containsLogin(String userName) {
        if (userName == null || userName.trim().isEmpty()) return false;

        for (Entry e : entries) {
            if (userName.equals(e.getLogin())) return true;
        }
        return false;
    }

    private void loadUsersFromDB() {
        if (entries == null) {
            entries = new ArrayList<>();
        } else {
            entries.clear();
        }

        try {
            ResultSet rs = selectUsersStatement.executeQuery();
            while (rs.next()) {
                String login = rs.getString(1);
                String password = rs.getString(2);
                String nick = rs.getString(3);
                entries.add(new Entry(login, password, nick));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }
    }
}
