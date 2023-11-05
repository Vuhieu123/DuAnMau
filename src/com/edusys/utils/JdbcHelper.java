/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utils;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vu Hieu
 */
public class JdbcHelper {

//    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=EduSys";
//    static String user = "sa";
//    static String pass = "Vuhieu123";
//
//    static {
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
//        Connection conn = DriverManager.getConnection(dburl, user, pass);
//        PreparedStatement stmt = null;
//        if (sql.trim().startsWith("{")) {
//            stmt = conn.prepareCall(sql); // PROC
//        } else {
//            stmt = conn.prepareStatement(sql); // SQL
//        }
//        for (int i = 0; i < args.length; i++) {
//            stmt.setObject(i + 1, args[i]);
//        }
//        return stmt;
//    }
//
//    public static void Update(String sql, Object... args) {
//
//        try {
//            PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
//            try {
//                stmt.executeUpdate();
//            } finally {
//                stmt.getConnection().close();
//            }
//        } catch (SQLException e) {
//           e.printStackTrace();
//        }
//    }
//
//    public static ResultSet query(String sql, Object... args) {
//        try {
//            PreparedStatement stmt = getStmt(sql, args);
//            return stmt.executeQuery();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "vuhieu281";
    private static final String SERVER = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "EduSys";
    private static final boolean USING_SSL = false;
   
    private static String CONNECT_STRING;
   
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           
            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(SERVER).append(":").append(PORT).append(";")
                    .append("databaseName=").append(DATABASE_NAME).append(";")
                    .append("user=").append(USERNAME).append(";")
                    .append("password=").append(PASSWORD).append(";")
                    ;
            if (USING_SSL) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
            System.out.println("Connect String có dạng: " + CONNECT_STRING);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static Connection getConnection()  {
         try {
             return DriverManager.getConnection(CONNECT_STRING);
         } catch (SQLException ex) {
             ex.printStackTrace();
             Logger.getLogger(JdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }
   
    public static void main(String[] args) throws Exception {
        Connection conn = getConnection();
        DatabaseMetaData dbmt = conn.getMetaData();
        System.out.println(dbmt.getDriverName());
        System.out.println(dbmt.getDatabaseProductName());
        System.out.println(dbmt.getDatabaseProductVersion());
    }


}
