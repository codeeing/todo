package com.codeeing.todo.domain;

//import com.example.project.security.PasswordEncoder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String nickname;
    private String passwd;
    private String profile_img;

    @JsonIgnore // 양방향 연관관계는 둘 중에 하나는 JsonIgnore를 해줘야한다. 그래야만 무한루프에 빠지지 않는다.
    @OneToMany(mappedBy = "member",fetch = LAZY) // 나는 연관관계의 주인이 아닌, Todo 엔티티의 member 필드에 의해 매핑이 된 거울일 뿐이다.
    // 1 대 N 설정. 1개의 Member는 N개의 Todo를 가질 수 있다.
    private List<Todo> todos = new ArrayList<>();

}
