package com.google.mvc.service;

import com.google.mvc.dao.TbFoodDao;
import com.google.mvc.dao.TbFoodDaoImpl;
import com.google.mvc.dto.TbFoodDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddListServlet", value = "/AddListServlet")
public class AddListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String menu = request.getParameter("menu");
        String img = request.getParameter("img");
        TbFoodDto dto = new TbFoodDto();
        dto.setName(menu);
        dto.setImg(img);

        TbFoodDao dao = new TbFoodDaoImpl();
        int result = dao.save(dto);
        // ajax에 result 정보 전달
        PrintWriter out = response.getWriter();
        out.println(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
