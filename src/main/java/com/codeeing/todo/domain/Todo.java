package com.codeeing.todo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter @Setter
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Long id;
    private LocalDate today;
    private String todoJson; // todo를 JSON 형식으로 저장

    @ManyToOne(fetch = FetchType.LAZY) // FetchType.EAGER가 default
    @JoinColumn(name = "member_id") // 연관관계 주인
    private Member member;

    @JsonIgnore // 양방향 연관관계는 둘 중에 하나는 JsonIgnore를 해줘야한다. 그래야만 무한루프에 빠지지 않는다.
    @OneToMany(mappedBy = "todo") // 나는 연관관계의 주인이 아닌, Reply 엔티티의 todo 필드에 의해 매핑이 된 거울일 뿐이다.
    // 1 대 N 설정. 1개의 Member는 N개의 Order를 가질 수 있다.
    private List<Reply> replies = new ArrayList<>();
}
