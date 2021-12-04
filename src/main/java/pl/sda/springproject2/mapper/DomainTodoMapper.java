package pl.sda.springproject2.mapper;

import pl.sda.springproject2.dto.NewTodoDto;
import pl.sda.springproject2.entity.EntityToDo;
import pl.sda.springproject2.model.DomainTodo;

import java.time.LocalDate;

public class DomainTodoMapper {
    public  static DomainTodo mapFromEntity(EntityToDo entity){
      return   DomainTodo.builder()
                .deadline(entity.getDeadline())
                .title(entity.getTitle())
                .id(entity.getId())
                .completed(entity.isCompleted())
                .person(entity.getPerson())
                .build();

    }
    public static EntityToDo mapToEntity(NewTodoDto newTodoDto){
        EntityToDo entityToDo = new EntityToDo();
        entityToDo.setDeadline(LocalDate.parse(newTodoDto.getDeadline()));
        entityToDo.setPerson(newTodoDto.getPerson());
        entityToDo.setTitle(newTodoDto.getTitle());
        entityToDo.setCompleted(false);
        return entityToDo;
    }
}
