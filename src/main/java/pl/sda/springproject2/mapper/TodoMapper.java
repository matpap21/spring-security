package pl.sda.springproject2.mapper;

import pl.sda.springproject2.entity.EntityToDo;
import pl.sda.springproject2.model.ToDo;

import java.time.LocalDate;

public class TodoMapper {

    public static EntityToDo mapToEntity(ToDo toDo){
        EntityToDo entityToDo = new EntityToDo();
        entityToDo.setTitle(toDo.getTitle());
        entityToDo.setPerson(toDo.getPerson());
        entityToDo.setDeadline(LocalDate.parse(toDo.getDeadline()));

        return entityToDo;
    }
    public static ToDo mapFromEntity(EntityToDo toDo){
       return ToDo.builder()
               .id(toDo.getId())
               .title(toDo.getTitle())
               .person(toDo.getPerson())
               .created(toDo.getCreated())
               .deadline(toDo.getDeadline().toString())
               .completed(toDo.isCompleted())
               .build();

    }
}
