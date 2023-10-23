package com.happysy.gpc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JDBConnection {

    private static String URL = "jdbc:mysql://10.2.0.19:3306/mole_crawler";
    private static String USERNAME = "pablo";
    private static String PASSWORD = "mercado10";

    private static Connection connection;

    public static void startConnection() {
        System.out.println("Estabelecendo Conexão");
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro ao Estabelecer Conexão: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        System.out.println("Encerrando Conexão");
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            throw new RuntimeException();
        }
    }

    public static void statusConnection() {
        try {
            System.out.println(connection.isValid(10));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        JDBConnection.URL = URL;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static void setUSERNAME(String USERNAME) {
        JDBConnection.USERNAME = USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        JDBConnection.PASSWORD = PASSWORD;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        JDBConnection.connection = connection;
    }
}
