package pl.sda.springproject2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springproject2.dto.NewBookDto;
import pl.sda.springproject2.model.Book;
import pl.sda.springproject2.service.BookService;


import java.util.List;

@RestController
@RequestMapping("/api/v2/books")
public class RestJpaBookController {
    private final BookService bookService;

    public RestJpaBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooks(){
        return bookService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Book> addBook(@RequestBody NewBookDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(dto));
    }

}
