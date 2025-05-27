package repository;

import domain.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryTodoRepository {

    private static MemoryTodoRepository memoryTodoRepository;

    private static ArrayList<Todo> store = new ArrayList<>();

    private MemoryTodoRepository() {
    }

    public static MemoryTodoRepository getInstance(){
        if(memoryTodoRepository == null){
            memoryTodoRepository = new MemoryTodoRepository();
        }
        return memoryTodoRepository;
    }

    public Todo save(Todo todo){
        store.add(todo);
        return todo;
    }

    public Optional<Todo> findById(int id){
        return store.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst();
    }

    public List<Todo> findAll(){
        return store;
    }

    public Todo delete(int id){
        Optional<Todo> findTodo = store.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst();
        Todo todo = findTodo.orElseThrow(() -> new IllegalArgumentException("없음"));
        store.remove(todo);
        return todo;
    }
}
