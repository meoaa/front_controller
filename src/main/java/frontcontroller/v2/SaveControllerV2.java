package frontcontroller.v2;

import domain.Todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.MemoryTodoRepository;

import java.io.IOException;

public class SaveControllerV2 implements ControllerV2{

    private final MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    public String process(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        Todo todo = new Todo(title);
        repository.save(todo);
        request.setAttribute("todo", todo);

        return "view";
    }
}
