package pl.sda.springproject2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.sda.springproject2.dto.NewTodoDto;
import pl.sda.springproject2.model.DomainTodo;
import pl.sda.springproject2.model.ToDo;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController // kazda metoda w kontrolerze, bedzie zwracac cialo odpowiedzi
public class RestTodoController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/api/v1/todos")
    public ResponseEntity<ToDo> addTodo(@Valid @RequestBody NewTodoDto dto) { // z ciala zadania wyciagnie te dane i sporobuke przemapowac do Todo
        // Todo zapisac do bazy przeslane zadanie
        final ToDo todo = ToDo.builder()
                .person(dto.getPerson())
                .title(dto.getTitle())
                .deadline(dto.getDeadline().toString())
                .id(100)
                .created(Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @GetMapping("/api/v1/todos/{id}")
    public ResponseEntity<ToDo> readTodo(@PathVariable long id) {
        final ToDo toDo =
                ToDo.builder()
                        .completed(false)
                        .id(id)
                        .title("Testowy")
                        .person("Zypherus")
                        .deadline("2021-12-12")
                        .build();
        return ResponseEntity.of(id < 10 ? Optional.of(toDo) : Optional.empty());

    }

    @PutMapping("/api/v1/todos/{id}")
    public ResponseEntity<ToDo> updateTodo(@PathVariable long id, @RequestBody NewTodoDto todoUpdate) {
        // TODO wyciagamy obiekt o danym numerze id z reporzytorium i  zmieniamy w nim pola na wartosci w todoUpdate
        ToDo toDo = ToDo.builder()
                .person(todoUpdate.getPerson())
                .deadline(todoUpdate.getDeadline())
                .title(todoUpdate.getTitle())
                .id(id)
                .build();

        return ResponseEntity.of(id < 10 ? Optional.of(toDo) : Optional.empty());

    }
    @PatchMapping("/api/v1/todos/{id}")
    public ResponseEntity<ToDo> setTodoAsCompleted(@PathVariable long id){
        // TODO wyciagnac zadanie z repozytorium i ustawic w nim pole completed na true
        ToDo toDo = ToDo.builder()
                .person("Nowy test z patch mapping")
                .deadline("2021-12-30")
                .title("test z patch mapping")
                .id(id)
                .completed(true) //
                .build();
        return ResponseEntity.of(id < 10 ? Optional.of(toDo) : Optional.empty());
    }
    @DeleteMapping("/api/v1/todos/{id}")
    public ResponseEntity<ToDo> deleteTodo(@PathVariable long id){
        // TODO usunac z repozytorium obiekt o danym id
        ToDo toDo = ToDo.builder()
                .person("Nowy test z delete")
                .deadline("2021-12-30")
                .title("test z patch delete")
                .id(id)
                .completed(true) //
                .build();
        return ResponseEntity.of(id < 10 ? Optional.of(toDo) : Optional.empty());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExeption(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(
                error -> {
                    errors.put(((FieldError) error).getField(),error.getDefaultMessage());

                }
        );
        return  errors;
    }


}



