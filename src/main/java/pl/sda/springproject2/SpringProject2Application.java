package pl.sda.springproject2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springproject2.entity.AppUser;
import pl.sda.springproject2.entity.Article;
import pl.sda.springproject2.entity.Author;
import pl.sda.springproject2.entity.EntityBook;
import pl.sda.springproject2.repository.*;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringProject2Application implements CommandLineRunner {
    final TodoRepository todoRepository;
    final BookRepository bookRepository;
    final ArticleRepository articleRepository;
    final AuthorRepository authorRepository;
    final AppUserRepository appUserRepository; // ********** jesli uzywasz SecurityConfig to trzeba to zablokowac

    public SpringProject2Application(TodoRepository todoRepository, BookRepository bookRepository, ArticleRepository articleRepository, AuthorRepository authorRepository, AppUserRepository appUserRepository) {
        this.todoRepository = todoRepository;
        this.bookRepository = bookRepository;
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.appUserRepository = appUserRepository; // ********** jesli uzywasz SecurityConfig to trzeba to zablokowac
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringProject2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //       EntityToDo
        //              toDo = new EntityToDo();
        //       toDo.setPerson("Gierwazy");
        //       toDo.setTitle("Testowanie");
        //       toDo.setDeadline((LocalDate.of(2021, 12, 30)));
        //       todoRepository.save(toDo);

        //      toDo = new EntityToDo();
        //       toDo.setPerson("Mieszko");
        //      toDo.setTitle("Testowanie2");
        //       toDo.setDeadline((LocalDate.of(2021, 12, 30)));
        //       todoRepository.save(toDo);

        //       toDo = new EntityToDo();
//        toDo.setPerson("Gierwazy");
        //       toDo.setTitle("Testowanie3");
        //       toDo.setDeadline((LocalDate.of(2021, 12, 30)));
        //       todoRepository.save(toDo);

        //      System.out.println(todoRepository.findAll());


        bookRepository.save(EntityBook.builder()
                .author("J.R.R Tolkien")
                .title("Hobbit")
                .build());

        bookRepository.save(EntityBook.builder()
                .author("J.R.R Tolkien")
                .title("Hobbit2")
                .build());

        bookRepository.save(EntityBook.builder()
                .author("Stephen King")
                .title("1409")
                .build());

        bookRepository.save(EntityBook.builder()
                .author("Stephen King")
                .title("Skazani na Shawshank")
                .build());

        System.out.println("Ksiazki danego autora");
        System.out.println(bookRepository.findByAuthor("J.R.R Tolkien"));
        System.out.println("Liczba ksiazek danego autora");
        System.out.println(bookRepository.countByAuthor("J.R.R Tolkien"));
        System.out.println("Liczba ksiazek danego autora o tytule zaczynajacym sie na litere S");
        System.out.println(bookRepository.countByAuthorAndAndTitleStartingWith("Stephen King", "S"));
        System.out.println(bookRepository.getAllTitles());
        //       List<Map<String, Object>> result =
        //      bookRepository.getIdAndTitles();
        //     result.forEach(row-> {
        //         List<Object> objectList = new ArrayList<>(row.values());
        //        System.out.println(objectList.get(0) + " " + objectList.get(1));
        //     });

        final List<Object[]> result2 = bookRepository.getIdAndTitles();
        result2.forEach(row -> {
            System.out.println(row[0] + " " + row[1]);
        });

        System.out.println("Zwiazek artykulow z autorami");
        Author author = Author.builder()
                .firstName("Zenek")
                .lastName("Martyniuk")
                .build();

        Article article = Article.builder()
                .title("Autobiografia")
                .authors(Set.of(author))
                .build();

        articleRepository.save(article);
        articleRepository.save(
                Article.builder()
                        .title("Koncerty")
                        .authors(Set.of(Author.builder()
                                .firstName("Zenon")
                                .lastName("Martyniuk")
                                .build()))
                        .build()

        );
        bookRepository.flush();
        System.out.println(articleRepository.findAll());
        System.out.println(authorRepository.findAll().get(0).getArticles());


        // ***********************************************************************************************//
        // ********** jesli uzywasz SecurityConfig to trzeba ten blok zablokowac
        // ponizszy blok dotyczy SecureConfig2

        appUserRepository.
                save(AppUser.builder()
                        .email("matpap21@wp.pl")
                        .password("$2a$12$9njK38D7aJZ.lrtXcVTna.QOs0t1f69HfP4tGqqK8leCjyLCtlKwK") // https://bcrypt-generator.com/
                        .enable(true)
                        .firstName("Mrokos")
                        .lastName("Mrokos")
                        .role("ROLE_ADMIN") // trzeba dodac przedrostek ROLE
                        .lastName("Nowak")
                        .build());

        appUserRepository.save(AppUser.builder()
                .email("admin@wp.pl")
                .password("$2a$12$9njK38D7aJZ.lrtXcVTna.QOs0t1f69HfP4tGqqK8leCjyLCtlKwK")// admin https://bcrypt-generator.com/
                .enable(true)
                .firstName("ADMIN")
                .lastName("ADMIN")
                .role("ROLE_ADMIN") // trzeba dodac przedrostek ROLE
                .build());

        appUserRepository.save(AppUser.builder()
                .email("ktos")
                .password("$2a$12$3pgQeMFQpamAISHdX.jxWeoA5VHJ23hjuATUOKcdqk.r69nR7rv06")// ktos https://bcrypt-generator.com/
                .enable(true)
                .firstName("KTOS")
                .lastName("KTOS")
                .role("ROLE_USER") // trzeba dodac przedrostek ROLE
                .build());

        appUserRepository.save(AppUser.builder()
                .email("user")
                .password("$2a$12$9njK38D7aJZ.lrtXcVTna.QOs0t1f69HfP4tGqqK8leCjyLCtlKwK")// ktos https://bcrypt-generator.com/
                .enable(true)
                .firstName("ADMIN")
                .lastName("ADMIN")
                .role("ROLE_ADMIN") // trzeba dodac przedrostek ROLE
                .build());

        // ***********************************************************************************************//
        // ********** jesli uzywasz SecurityConfig to trzeba ten blok zablokowac
        // powyzszy blok dotyczy SecureConfig2
    }
}
