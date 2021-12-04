package pl.sda.springproject2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.sda.springproject2.entity.EntityToDo;
import pl.sda.springproject2.mapper.TodoMapper;
import pl.sda.springproject2.repository.TodoRepository;
import pl.sda.springproject2.model.ToDo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary // ze wszystkich implementacji, ktore mam, wybierz ta implementacje
public class JpaTodoService implements ToDoService {
    private final TodoRepository todoRepository;

    public JpaTodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public ToDo add(ToDo toDo) {
       final EntityToDo save = todoRepository.save(TodoMapper.mapToEntity(toDo));
       toDo.setId(save.getId());
       toDo.setCreated(save.getCreated());
       toDo.setCompleted(save.isCompleted());
       return toDo;
    }

    @Override
    public List<ToDo> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(TodoMapper::mapFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void setAsCompleted(long id) {
       final Optional<EntityToDo> optionalEntityToDo = todoRepository.findById(id);
       if(optionalEntityToDo.isPresent()){
           final EntityToDo entityToDo =optionalEntityToDo.get();
           entityToDo.setCompleted(true);
           todoRepository.save(entityToDo);
       }
    }
}
