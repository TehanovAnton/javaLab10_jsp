package com.example.lab10_JSP;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DB {
    public static String MS_DB_URL = "jdbc:sqlserver://localhost:1433";
    public static String MS_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String MS_PASSWORD = "ewqqwe";
    public static String MS_USER_NAME = "Anton";

    public static boolean CheckUser(String username, String password){
        Connection conn = null;
        Boolean res = null;

        try {
            Class.forName(DB.MS_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB.MS_DB_URL, DB.MS_USER_NAME, DB.MS_PASSWORD);
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("use java10JDBC\n" +
                    "select * from UserLog where _username = '" + username +"' and _password = '" + password +"'");

            res = rs.next();
            st.close();

        } catch (SQLException | ClassNotFoundException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return res != null ? res.booleanValue() : false;
    }

    public static boolean SignInUser(String username, String password){
        Connection conn = null;
        Boolean res = !CheckUser(username, password);

        try {
            Class.forName(DB.MS_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB.MS_DB_URL, DB.MS_USER_NAME, DB.MS_PASSWORD);
            Statement st = conn.createStatement();

            //проверка наличия такого же пользователя
            if (res) {
                st.execute("use java10JDBC\n" +
                        "insert into UserLog(_username, _password) values('" + username + "', '" + password + "')");
            }

            st.close();
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return res != null && res;
    }

    public static boolean CheckChannel(String channel, String owner){
        Connection conn = null;
        Boolean res = null;

        try {
            Class.forName(DB.MS_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB.MS_DB_URL, DB.MS_USER_NAME, DB.MS_PASSWORD);
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("use java10JDBC\n" +
                    "select * from Channel where _channel = '" + channel +"' and _owner = '" + owner +"'");

            res = rs.next();
            st.close();

        } catch (SQLException | ClassNotFoundException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return res != null ? res.booleanValue() : false;
    }

    public static void AddNewChannel(String channel, String owner){
        Connection conn = null;
        Boolean res = !CheckChannel(channel, owner);

        try {
            Class.forName(DB.MS_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB.MS_DB_URL, DB.MS_USER_NAME, DB.MS_PASSWORD);
            Statement st = conn.createStatement();

            //проверка наличия такого же пользователя
            if (res) {
                st.execute("use java10JDBC\n" +
                        "insert into Channel(_channel, _owner) values('" + channel + "', '" + owner + "')");
            }

            st.close();
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Channel> getChannels(PrintWriter pw){
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<Channel> channels = new ArrayList<Channel>();

        try {
            Class.forName(DB.MS_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB.MS_DB_URL, DB.MS_USER_NAME, DB.MS_PASSWORD);
            Statement st = conn.createStatement();

            rs = st.executeQuery("use java10JDBC\n" +
                    "select * from Channel");

            while (rs.next()){
                channels.add(
                        new Channel(rs.getString("_channel"), rs.getString("_owner")));
            }

            st.close();
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return channels;
    }
}
