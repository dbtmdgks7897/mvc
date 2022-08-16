package com.google.mvc.dao;

import com.google.mvc.dto.TbFoodDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TbFoodDaoImpl implements TbFoodDao{
    static ResultSet rs = null;
    static PreparedStatement pstmt = null;
    static Connection conn = null;

    public static Connection dbConnect() {
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

    @Override
    public int save(TbFoodDto dto) {
        int result = 0; // 저장 성공 여부
        Connection conn = dbConnect();

        try {
            String sql = "INSERT INTO `tb_food` (`name`, `img`) VALUES (? , ?);";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getImg());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public TbFoodDto findRandOne() {
        TbFoodDto dto = new TbFoodDto();
        Connection conn = dbConnect();

        try {
            String sql = "SELECT * FROM tb_food ORDER BY RAND() LIMIT 1";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setImg(rs.getString("img"));
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dto;
    }

    @Override
    public void update() {

    }

    public List<TbFoodDto> findAll() {
        List<TbFoodDto> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = dbConnect();
        try {
            String sql = "SELECT * FROM tb_food";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TbFoodDto dto = new TbFoodDto();
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setImg(rs.getString("img"));
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
