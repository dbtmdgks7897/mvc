package com.google.mvc.dao;

import com.google.mvc.dto.TbFoodDto;
import com.google.mvc.dto.TbUserDto;

import java.sql.*;

public class TbUserDaoImpl implements TbUserDao{
    @Override
    public void register() {

    }

    @Override
    public TbUserDto findEmailPw(String email, String pw) {
        TbUserDto dto = null;
        Connection conn = DB.conn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tb_user WHERE `email` = ? AND `userpw` = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new TbUserDto();
                dto.setId(rs.getInt("id"));
                dto.setEmail(rs.getString("email"));
                dto.setName(rs.getString("name"));
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
}


