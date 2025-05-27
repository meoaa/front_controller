package frontcontroller.v3;

import domain.Todo;
import frontcontroller.ModelView;
import repository.MemoryTodoRepository;

import java.util.HashMap;
import java.util.Map;

public class SaveControllerV3 implements ControllerV3{

    private final MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String title = paramMap.get("title");
        Todo todo = new Todo(title);
        repository.save(todo);
        HashMap<String, Object> model = new HashMap<>();
        model.put("todo", todo);
        return new ModelView(model, "view");
    }
}
