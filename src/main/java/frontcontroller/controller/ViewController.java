package frontcontroller.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "viewController", urlPatterns = "/view")
public class ViewController extends HttpServlet {
    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("view Controller");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/controller/view.html");
        dispatcher.forward(request,response);
    }
}
