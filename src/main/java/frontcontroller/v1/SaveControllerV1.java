package frontcontroller.v1;

import domain.Todo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.MemoryTodoRepository;

import java.io.IOException;

public class SaveControllerV1 implements ControllerV1{

    MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SaveControllerV1.process");

        String title = request.getParameter("title");

        Todo todo = new Todo(title);
        repository.save(todo);

        request.setAttribute("todo", todo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/controller/view.jsp");
        dispatcher.forward(request,response);
    }
}
