package frontcontroller.v2;

import domain.Todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.MemoryTodoRepository;

import java.io.IOException;
import java.util.List;

public class ListControllerV2 implements ControllerV2{

    private final MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    public String process(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("ListControllerV2.process");
        List<Todo> todo = repository.findAll();
        request.setAttribute("todo", todo);

        return "list";
    }
}
