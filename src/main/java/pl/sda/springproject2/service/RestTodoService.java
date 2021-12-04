package pl.sda.springproject2.service;

import pl.sda.springproject2.dto.NewTodoDto;
import pl.sda.springproject2.model.DomainTodo;

import java.util.List;
import java.util.Optional;

public interface RestTodoService {
    DomainTodo save(NewTodoDto newTodoDto);
    Optional<DomainTodo> update(DomainTodo domainTodo); // obiekt ktoey jest zarejestrowany w sysmienie. mozna zmienic pola, obiekt mutualny
    Optional<DomainTodo> delete(long id);
    Optional<DomainTodo> findById(long id);
    List<DomainTodo> findAll();
    void setAsCompleted(long id);
    }

