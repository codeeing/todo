package com.codeeing.todo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Reply {
    @Id
    @GeneratedValue
    @Column(name = "reply_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // FetchType.EAGER가 default
    @JoinColumn(name = "todo_id") // 연관관계 주인. Reply 테이블에서 todo_id FK를 지니고 있으니까.
    private Todo todo;

    private String replyJson; // reply를 JSON 형식으로 저장
}
