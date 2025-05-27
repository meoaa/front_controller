package frontcontroller.controller;

import domain.Todo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.MemoryTodoRepository;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "listController", urlPatterns = "/list")
public class ListController extends HttpServlet {

    private final MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        System.out.println("listController");

        List<Todo> todos = repository.findAll();

        request.setAttribute("todo", todos);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/controller/list.jsp");

        dispatcher.forward(request,response);
    }
}
