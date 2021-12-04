package pl.sda.springproject2.service;

import org.springframework.stereotype.Service;
import pl.sda.springproject2.dto.NewTodoDto;
import pl.sda.springproject2.entity.EntityToDo;
import pl.sda.springproject2.mapper.DomainTodoMapper;
import pl.sda.springproject2.model.DomainTodo;
import pl.sda.springproject2.repository.TodoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class JPARestTodoService implements RestTodoService {
    private final TodoRepository todoRepository;

    public JPARestTodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public DomainTodo save(NewTodoDto newTodoDto) {
        return DomainTodoMapper.mapFromEntity(todoRepository.save(DomainTodoMapper.mapToEntity(newTodoDto)));
    }

    @Override
    public Optional<DomainTodo> update(DomainTodo domainTodo) {
        final Optional<EntityToDo> optionalEntityToDo = todoRepository.findById(domainTodo.getId());
        if (optionalEntityToDo.isPresent()) {
            final EntityToDo entityToDo = optionalEntityToDo.get();
            entityToDo.setTitle(domainTodo.getTitle());
            entityToDo.setPerson(domainTodo.getPerson());
            entityToDo.setDeadline(domainTodo.getDeadline());
            todoRepository.save(entityToDo); // update encji
            return Optional.of(DomainTodoMapper.mapFromEntity(entityToDo));

        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<DomainTodo> delete(long id) {
        final Optional<EntityToDo> optionalEntityToDo = todoRepository.findById(id);
        if (optionalEntityToDo.isPresent()) {
            todoRepository.deleteById(id);
            return optionalEntityToDo.map(DomainTodoMapper::mapFromEntity);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<DomainTodo> findById(long id) {
        return todoRepository.findById(id).map(entity->DomainTodoMapper.mapFromEntity(entity));
    }

    @Override
    public List<DomainTodo> findAll() {
        return todoRepository.findAll().stream().map(entity->DomainTodoMapper.mapFromEntity(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void setAsCompleted(long id) {
        Optional<EntityToDo> optionalEntityToDo = todoRepository.findById(id);
        if (optionalEntityToDo.isPresent()){
            EntityToDo entityToDo = optionalEntityToDo.get();
            entityToDo.setCompleted(true);
            todoRepository.save(entityToDo);
        }
    }
}
