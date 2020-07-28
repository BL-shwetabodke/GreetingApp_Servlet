package com.bridgelabz.greetingapp.controllers;

import com.bridgelabz.greetingapp.dao.GreetingDAO;
import com.bridgelabz.greetingapp.model.Greeting;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddGreetingController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        GreetingDAO.getConnection();
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String greetingMessage = httpServletRequest.getParameter("greetingMessage");
        Greeting greeting = new Greeting(greetingMessage);
        GreetingDAO.createGreeting(greeting);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(httpServletResponse.encodeURL("/"));
        requestDispatcher.include(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {
        super.destroy();
        GreetingDAO.close();
    }
}
