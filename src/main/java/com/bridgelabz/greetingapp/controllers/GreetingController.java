package com.bridgelabz.greetingapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GreetingController extends HttpServlet {

//    @Override
//    public void init() throws ServletException {
//        super.init();
//    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String greetingMessage = httpServletRequest.getParameter("greetingMessage");
        System.out.println("hello world");
        System.out.println(greetingMessage);    }

    //    @Override
//    public void destroy() {
//        super.destroy();
//    }
}
