package pl.sda.springproject2.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springproject2.dto.NewBookDto;
import pl.sda.springproject2.model.Book;


import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class RestBookController {

    @PostMapping( "")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
        book.setId(100);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping( "/{id}")
    public ResponseEntity<Book> readBook(@PathVariable long id){
        Book book = new Book();
        book.setId(id);
        book.setAuthor("Autor");
        book.setTitle("Tytuł");
        return ResponseEntity.of(id < 20 ? Optional.of(book) : Optional.empty());
    }

    @PatchMapping( "/author/{id}")
    public ResponseEntity<Book> updateBookAuthor(@PathVariable long id, @RequestParam String value){
        System.out.println(id);
        System.out.println(value);
        return ResponseEntity.ok().build();
    }
}
