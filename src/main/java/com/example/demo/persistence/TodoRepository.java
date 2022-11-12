package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {

    List<TodoEntity> findByUserId(String userId);
    /*
    // 더 복잡한 쿼리는 아래와 같이 @Query 어노테이션을 사용하여 지정 가능
    // ?1은 메서드의 매개변수의 순서 위치
    @Query("select * from Todo t where t.userId = ?1")
    List<TodoEntity> findByUserId(String userId);
     */
}
