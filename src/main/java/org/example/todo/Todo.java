package org.example.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor // Lombok이 기본 생성자를 자동으로 생성합니다.
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task; // task 필드로 변경
    private boolean completed;

    // 매개변수가 있는 생성자
    public Todo(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }
}