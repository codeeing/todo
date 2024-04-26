package com.codeeing.todo.entity;

//import com.example.project.security.PasswordEncoder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TodoUsers {
    @Id
    private String email;
    private String nickname;
    private String passwd;
    private String profile_img;

//    public TodoUsers hashPassword(PasswordEncoder passwordEncoder) {
//        this.passwd = passwordEncoder.encode(this.passwd);
//        return this;
//    }
//    public boolean checkPassword(String plainPassword, PasswordEncoder passwordEncoder) {
//        return passwordEncoder.matches(plainPassword, this.passwd);
//    }
}
