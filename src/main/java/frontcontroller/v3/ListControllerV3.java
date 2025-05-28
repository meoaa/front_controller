package frontcontroller.v3;

import domain.Todo;
import frontcontroller.ModelView;
import repository.MemoryTodoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListControllerV3 implements ControllerV3{

    private final MemoryTodoRepository repository = MemoryTodoRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        System.out.println("ListControllerV3.process");
        List<Todo> todo = repository.findAll();
        HashMap<String, Object> model = new HashMap<>();
        model.put("todo", todo);

        return new ModelView(model, "list");
    }
}
