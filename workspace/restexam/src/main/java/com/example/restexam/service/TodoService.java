package com.example.restexam.service;

import com.example.restexam.entity.Todo;
import com.example.restexam.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<Todo> getTodoList(){
        return todoRepository.findAll();
    }
    @Transactional
    public void addTodoList(Todo todo){
        if(todo==null){
            throw new NullPointerException();
        }
        todoRepository.save(todo);
        log.info("📌"+todo.toString());
    }
    @Transactional(readOnly = true)
    public Todo getTodo(Long id){
        return todoRepository.findById(id).orElseThrow();
    }
    @Transactional
    public void deleteTodo(Todo todo){
        if(todo == null)
            throw new NullPointerException();
        todoRepository.delete(todo);
    }
    @Transactional
    public void updateDone(Todo todo){
        todoRepository.save(todo);
    }


}
