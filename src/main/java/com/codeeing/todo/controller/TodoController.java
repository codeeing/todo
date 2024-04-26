package com.codeeing.todo.controller;

import com.codeeing.todo.entity.TodoUsers;
import com.codeeing.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// Presentation Layer
@RestController // @Controller + @ResponseBody
@RequiredArgsConstructor
@RequestMapping("/todo-users")
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public void register(@RequestBody Map<String, Object> map){
        todoService.createUser(map);
    }
    @GetMapping(value = "/{email}/{passwd}")
    public TodoUsers login(@PathVariable String email, @PathVariable String passwd){
        return todoService.readUser(email, passwd);
    }

}
