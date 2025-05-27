package frontcontroller.v4;

import domain.Todo;
import repository.MemoryTodoRepository;

import java.util.Map;

public class SaveControllerV4 implements ControllerV4{

    private final MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        System.out.println("SaveControllerV4.process");
        String title = paramMap.get("title");
        Todo todo = new Todo(title);
        repository.save(todo);
        model.put("todo", todo);

        return "view";
    }
}
