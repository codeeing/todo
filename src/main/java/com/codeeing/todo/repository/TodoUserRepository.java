package com.codeeing.todo.repository;

import com.codeeing.todo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoUserRepository extends JpaRepository<Member, String> {
     Member findByEmail(String email);
    @Query(value = "select count(*) from todo_users u where u.email = :email and u.passwd = :passwd", nativeQuery = true)
    int checkUser(String email, String passwd);
}
