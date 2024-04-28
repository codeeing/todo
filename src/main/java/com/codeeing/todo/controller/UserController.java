package com.codeeing.todo.controller;

import com.codeeing.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/users/register")
    public String createForm(){
        return "users/registerForm";
    }
    @PostMapping("/users/register")
    public String create(){
        return "redirect:/";
    }
    @GetMapping("/users/{userId}")
    public String read(@PathVariable("userId") Long userId){//, @ModelAttribute("form") BookForm form
        return null;
    }
    public String update(){
        return null;
    }

    public String delete(){
        return null;
    }
}
