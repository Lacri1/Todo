package org.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    // 모든 Todo 항목 가져오기 (API용)
    @GetMapping
    @ResponseBody // JSON 응답을 반환하도록 설정
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    // Todo 리스트를 조회하여 index.html로 전달
    @GetMapping("/list")
    public String getTodosForView(Model model) {
        List<Todo> todos = todoRepository.findAll(); // 데이터베이스에서 Todo 리스트 조회
        model.addAttribute("todos", todos); // 모델에 todos 추가
        return "index"; // index.html로 이동
    }

    // 새로운 Todo 항목 추가하기
    @PostMapping
    @ResponseBody // JSON 응답을 반환하도록 설정
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo savedTodo = todoRepository.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo); // 생성된 Todo 반환
    }

    // 특정 Todo 항목의 완료 상태를 토글(반전)하기
    @PutMapping("/{id}")
    @ResponseBody // JSON 응답을 반환하도록 설정
    public ResponseEntity<Todo> toggleTodoStatus(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));

        // 완료 상태를 반전시킴
        todo.setCompleted(!todo.isCompleted());

        Todo savedTodo = todoRepository.save(todo);
        return ResponseEntity.ok(savedTodo); // 업데이트된 Todo 반환
    }

    // 특정 Todo 항목 삭제하기
    @DeleteMapping("/{id}")
    @ResponseBody // JSON 응답을 반환하도록 설정
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // 삭제 성공 시 204 No Content 반환
    }
}
