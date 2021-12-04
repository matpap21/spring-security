package pl.sda.springproject2.service;

import org.springframework.stereotype.Service;
import pl.sda.springproject2.dto.NewBookDto;
import pl.sda.springproject2.entity.EntityBook;
import pl.sda.springproject2.mapper.BookMapper;
import pl.sda.springproject2.model.Book;
import pl.sda.springproject2.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class JpaBookService implements BookService {
    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(NewBookDto newBookDto) {
       return BookMapper.mapFromEntity(bookRepository.save(BookMapper.mapToEntity(newBookDto)));

    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::mapFromEntity)
                .collect(Collectors.toList());
    }
}

