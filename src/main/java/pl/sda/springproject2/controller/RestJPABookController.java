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
public class RestJPABookController {
    private final BookService bookService;

    public RestJPABookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBook() {
        return bookService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Book> addBoook(@RequestBody NewBookDto bookDto) {
      return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookDto));

    }
}
