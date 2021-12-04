package pl.sda.springproject2.service;

import org.springframework.stereotype.Service;
import pl.sda.springproject2.model.ToDo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class ToDoServiceMemory implements  ToDoService{
    private Map<Long, ToDo> toDoMap = new HashMap<>(); // kluczem jest id
    private long currentId = 1;

    public ToDoServiceMemory() {
         ToDo toDo = ToDo.builder()
                .person("Marian")
                .title("Spring")
                .deadline("2021-12-01")
                .build();
        add(toDo);
        toDo = ToDo.builder()
                .person("Paweł")
                .title("Programowanie w Java")
                .deadline("2022-03-21")
                .build();
        add(toDo);
        add(ToDo.builder()
                .person("Zenek")
                .title("Koncert")
                .completed(true)
                .deadline("2022-10-10")
                .build());
    }

    @Override
    public ToDo add(ToDo toDo) {
        toDo.setId(currentId++);
        toDo.setCreated(new Timestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)*1000));
        toDoMap.put(toDo.getId(),toDo);
        return toDo;
    }

    @Override
    public List<ToDo> findAll() {
        return new ArrayList<>(toDoMap.values());
    }

    @Override
    public void setAsCompleted(long id) {
        toDoMap.get(id).setCompleted(true);

    }
}
