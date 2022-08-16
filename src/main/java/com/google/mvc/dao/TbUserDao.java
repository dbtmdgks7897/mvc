package com.google.mvc.dao;

import com.google.mvc.dto.TbFoodDto;
import com.google.mvc.dto.TbUserDto;

import java.sql.Connection;

public interface TbUserDao {
    public void register();
    public TbUserDto findEmailPw(String email, String pw);
}
