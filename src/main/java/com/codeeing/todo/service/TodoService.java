package com.codeeing.todo.service;

import com.codeeing.todo.entity.TodoUsers;
import com.codeeing.todo.repository.TodoUserRepository;
//import com.example.project.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

// Service Layer
@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoUserRepository todoUserRepository;
//    private static ModelMapper modelMapper = new ModelMapper();
    //private final PasswordEncoder bCryptPasswordEncoder;

    public void createUser(Map<String, Object> map) {

        TodoUsers todoUsers = new TodoUsers();
        todoUsers.setEmail(String.valueOf(map.get("email")));
        todoUsers.setNickname(String.valueOf(map.get("nickname")));
        todoUsers.setPasswd(String.valueOf(map.get("passwd")));
        todoUsers.setProfile_img(String.valueOf(map.get("profile_img")));
//        todoUserRepository.save(modelMapper.map(todoUsers,TodoUsers.class));
//        newUser.hashPassword(bCryptPasswordEncoder);
//        return todoUserRepository.save(newUser);

        //        if(this.isEmailExist(signUpReq.getEmail())) {
//            throw new Exception("Your Mail already Exist.");
//        }
    }
    public TodoUsers readUser(String email, String passwd){
        int res = todoUserRepository.checkUser(email, passwd);
        if(res == 0){
            return null;
        } else{
            return todoUserRepository.findByEmail(email);
        }
    }
}
