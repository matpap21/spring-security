package pl.sda.springproject2.mapper;

import pl.sda.springproject2.dto.NewBookDto;
import pl.sda.springproject2.entity.EntityBook;
import pl.sda.springproject2.model.Book;

public class BookMapper {
    public static EntityBook mapToEntity(NewBookDto newBookDto){
       return EntityBook.builder()
                .author(newBookDto.getAuthor())
                .title(newBookDto.getTitle())
                .build();


    }
    public static Book mapFromEntity(EntityBook entity){
        return Book.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .build();
    }
}
