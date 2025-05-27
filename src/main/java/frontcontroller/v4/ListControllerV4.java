package frontcontroller.v4;

import domain.Todo;
import repository.MemoryTodoRepository;

import java.util.List;
import java.util.Map;

public class ListControllerV4 implements ControllerV4{

    private final MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    public String process(
            Map<String, String> paramMap,
            Map<String, Object> model) {
        System.out.println("ListControllerV4.process");

        List<Todo> todo = repository.findAll();
        model.put("todo", todo);
        return "list";
    }
}
