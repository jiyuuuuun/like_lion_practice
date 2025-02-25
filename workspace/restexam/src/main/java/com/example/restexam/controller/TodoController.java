package com.example.restexam.controller;

import com.example.restexam.entity.Todo;
import com.example.restexam.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    //전체 할 일 조회
    @GetMapping
    public ResponseEntity<List<Todo>> getTodoList(){
        List<Todo> todoList=todoService.getTodoList();
        return ResponseEntity.ok(todoList);
    }
    //할 일 추가
    @PostMapping
    public ResponseEntity<Todo> addTodoList(@RequestBody Todo todo){
        todoService.addTodoList(todo);
        return ResponseEntity.ok(todo);
    }

    //할 일 완료/미완료 변경
    @PatchMapping("/{id}")
    public ResponseEntity<Todo> updateTodoDone(@PathVariable("id") Long id){
        Todo todo=todoService.getTodo(id);
        log.info("✳️Before"+todo.toString());
        if(todo.isDone()){
            todo.setDone(false);
        }else{
            todo.setDone(true);
        }
        log.info("✳️After"+todo.toString());
        todoService.updateDone(todo); //꼭 데이터 베이스에 반영!
        return ResponseEntity.ok(todo);
    }

    //할 일 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id){
        Todo todo=todoService.getTodo(id);
        todoService.deleteTodo(todo);
        return ResponseEntity.ok().build();
    }

}
