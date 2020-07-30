package com.bridgelabz.greetingapp.controllers;

import com.bridgelabz.greetingapp.dao.GreetingDAO;
import com.bridgelabz.greetingapp.model.Greeting;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/greeting")
public class GreetingController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        GreetingDAO.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        System.out.println(httpServletRequest.getServletPath());

        if(httpServletRequest.getServletPath().contains("delete")){
            doDelete(httpServletRequest,httpServletResponse);
        }else {
            List<Greeting> greetings = GreetingDAO.findAllGreetings();
            httpServletRequest.getSession().setAttribute("greetings", greetings);
            RequestDispatcher requestDispatcher =
                    httpServletRequest.getRequestDispatcher(httpServletResponse.encodeURL("index.jsp"));
            try {
                requestDispatcher.forward(httpServletRequest, httpServletResponse);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        String firstName = httpServletRequest.getParameter("firstName");
        String lastName = httpServletRequest.getParameter("lastname");
        Greeting greeting =
                new Greeting(new StringBuilder("Hello, ").append(firstName).append(" ").append(lastName).toString());
        GreetingDAO.createGreeting(greeting);
        httpServletResponse.sendRedirect("greeting");
    }

    @Override
    protected void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String id = httpServletRequest.getParameter("id");
        GreetingDAO.deleteById(Integer.parseInt(id));
        httpServletResponse.sendRedirect("/greeting");
    }

    @Override
    public void destroy() {
        super.destroy();
        GreetingDAO.close();
    }
}
