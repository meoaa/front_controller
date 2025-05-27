package frontcontroller.v1;

import domain.Todo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.MemoryTodoRepository;

import java.io.IOException;
import java.util.List;

public class ListControllerV1 implements ControllerV1 {

    private final MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("list controller v1");

        List<Todo> todo = repository.findAll();

        request.setAttribute("todo", todo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/controller/list.jsp");

        dispatcher.forward(request,response);
    }
}
