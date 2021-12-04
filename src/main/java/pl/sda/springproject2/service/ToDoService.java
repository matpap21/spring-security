package pl.sda.springproject2.service;

import pl.sda.springproject2.model.ToDo;

import java.util.List;

public interface ToDoService {
    ToDo add(ToDo toDo);
    List<ToDo> findAll();
    void setAsCompleted(long id);
}
