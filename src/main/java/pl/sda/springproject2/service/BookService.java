package pl.sda.springproject2.service;

import pl.sda.springproject2.dto.NewBookDto;
import pl.sda.springproject2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(NewBookDto newBookDto);
    List<Book> findAll();
}
