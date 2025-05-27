package frontcontroller.v1;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddControllerV1 implements ControllerV1{

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddControllerV1.process");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/controller/add.jsp");
        dispatcher.forward(request, response);
    }
}

