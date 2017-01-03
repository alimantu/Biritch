package ru.epam.salynskii.core.biritch.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alimantu on 03/09/16.
 */
@WebServlet("/test")
public class Test extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("variant", "doPost");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/forwardedTest");
        requestDispatcher.forward(req, resp);
    }
}
