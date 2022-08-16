package com.google.mvc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Controller", value = "*.gg")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("getRequestURI : " + uri);
        out.println("<br />");
        out.println("getRequestURL : " + url);

        String path = null;
        // main.gg - 메인 페이지 화면
        if(uri.equals("/main.gg")){
            path = "main.jsp";
//            out.println("메인 페이지");
        }
        // movie.gg - 영화 정보 페이지
        else if(uri.equals("/movie.gg")){
            path = "movie.jsp";
//            out.println("영화 정보 페이지");
        }
        // search.gg - 검색 화면
        else if(uri.equals("/search.gg")){
            path = "search.jsp";
//            out.println("검색 화면");
        }
        // foodrandom.gg - 음식 랜덤
        else if(uri.equals("/foodrandom.gg")){
            path = "/FoodRandomServlet";
//            out.println("랜덤 음식"); - O
        }
        // foodlist.gg - 음식 리스트
        else if(uri.equals("/foodlist.gg")){
            path = "FoodListServlet";
//            out.println("랜덤 음식"); - O
        }
        // addlist.gg - 음식 추가
        else if(uri.equals("/addlist.gg")){
            path = "AddListServlet";
//            out.println("랜덤 음식"); - O
        }
        // login.gg - 로그인 창
        else if(uri.equals("/login.gg")){
            path = "login.jsp";
//            out.println("로그인 창");
        }
        //loginok.gg
        else if(uri.equals("/loginok.gg")){
            path = "LoginOkServlet";
//            out.println("로그인 창");
        }
        //logout.gg
        else if(uri.equals("/logout.gg")){
            path = "logout.jsp";
//            out.println("로그인 창");
        }
        // naver.gg - 네이버로
        else if (uri.equals("/naver.gg")) {
            response.sendRedirect("https://www.naver.com/");
        } else {
            out.println("잘못된 접근");
        }
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);
        // register 등

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
