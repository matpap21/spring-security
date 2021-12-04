package pl.sda.springproject2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.sda.springproject2.errors.ValidationExeptionHandler;
import pl.sda.springproject2.model.Book;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RestBookController extends ValidationExeptionHandler {
    @PostMapping("")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) { // z ciala zadania wyciagnie te dane i sporobuke przemapowac do Todo
        // Todo zapisac do bazy przeslane zadanie
        book.setId(100);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> readBook(@PathVariable long id) {
        Book book = new Book();
        book.setId(id);
        book.setAuthor("Author");
        book.setTitle("Tytul kasiazki");

        return ResponseEntity.of(id < 15 ? Optional.of(book) : Optional.empty());
    }
    @PatchMapping("/author/{id}")
    public ResponseEntity<Book> updateBookAuthor(@PathVariable long id, @RequestParam String value){
        System.out.println(id);
        System.out.println(value);
        return ResponseEntity.ok().build();
    }

}
