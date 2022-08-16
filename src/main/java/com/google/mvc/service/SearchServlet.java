package com.google.mvc.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.mvc.dao.TbSearchDao;
import com.google.mvc.dao.TbSearchDaoImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String search = request.getParameter("search");

        TbSearchDao NaverApiSearch = new TbSearchDaoImpl();
        String searchData = NaverApiSearch.newsApi(search);

//        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//        String json = gson.toJson(searchData);
//        System.out.println(json);

        RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
        request.setAttribute("searchData", searchData);
        request.setAttribute("search", search);
        dis.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
