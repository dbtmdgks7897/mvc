package com.google.mvc.service;

import com.google.mvc.dao.*;
import com.google.mvc.dto.TbFoodDto;
import com.google.mvc.dto.TbUserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "LoginOkServlet", value = "/LoginOkServlet")
public class LoginOkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TbUserDao dao = new TbUserDaoImpl();
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String pw = request.getParameter("userpw");
        TbUserDto dto = dao.findEmailPw(email, pw);
        if(dto != null){
//            RequestDispatcher dis = request.getRequestDispatcher("foodrandom.jsp");
            System.out.println("성공");
            HttpSession session = request.getSession();
            session.setAttribute("username", dto.getName());
            response.sendRedirect("main.gg");
        }else{
            System.out.println("실패");
            response.sendRedirect("login.gg");
        }
//        request.setAttribute("foodDto", dto);
//        dis.forward(request, response);


        // ajax에 result 정보 전달
        PrintWriter out = response.getWriter();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}