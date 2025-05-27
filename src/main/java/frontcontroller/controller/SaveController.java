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

@WebServlet(name = "viewController", urlPatterns = "/save")
public class SaveController extends HttpServlet {

    private final MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("save Controller");

        String title = request.getParameter("title");
        System.out.println("title = " + title);
        Todo todo = new Todo(title);
        repository.save(todo);

        request.setAttribute("todo", todo);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/controller/view.jsp");

        dispatcher.forward(request,response);
    }
}
