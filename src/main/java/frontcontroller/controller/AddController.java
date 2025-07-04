package frontcontroller.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.MemoryTodoRepository;

import java.io.IOException;

@WebServlet(name = "addController", urlPatterns = "/add")
public class AddController extends HttpServlet {

    private final MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("add controller");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/controller/add.jsp");
        dispatcher.forward(request,response);
    }
}
