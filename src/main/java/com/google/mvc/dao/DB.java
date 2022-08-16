package com.google.mvc.dao;

import java.sql.*;

public class DB {
    static ResultSet rs = null;
    static PreparedStatement pstmt = null;
    static Connection conn = null;

    public static Connection conn() {
        Connection conn = null;
        final String driver = "org.mariadb.jdbc.Driver"; //패키지
        final String DB_IP = "localhost"; //접속 아이피
        final String DB_PORT = "3306"; //포트
        final String DB_NAME = "database"; //DB 이름
        final String DB_URL = //DB 연결 방식
                "jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(DB_URL, "root", "1234");
            if (conn != null) {
                System.out.println("DB 접속 성공");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
        return conn;
    }
}
