package com.bridgelabz.greetingapp.controllers;

import com.bridgelabz.greetingapp.dao.GreetingDAO;
import com.bridgelabz.greetingapp.model.Greeting;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetGreetingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        GreetingDAO.getConnection();
        List<String> greetings = GreetingDAO.findAllGreetings();
        for (String greeting: greetings) {
            System.out.println(greeting);
        }
        httpServletRequest.getSession().setAttribute("greetings", greetings);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(httpServletResponse.encodeURL("home.jsp"));
        try {
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
