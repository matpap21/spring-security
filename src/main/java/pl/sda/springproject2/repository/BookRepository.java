package pl.sda.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.springproject2.entity.EntityBook;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<EntityBook,Long> {
    // metody generowane przez Springa Jpa na podstawie sygnatury
    List<EntityBook> findByAuthor(String author);
    int countByAuthor(String author);
    int countByAuthorAndAndTitleStartingWith(String author, String tileStart);

    // metoda generowana na podsatwie JPQL w adnotacji Query
    @Query(value = "select b.title from EntityBook b",nativeQuery = false)
    List<String> getAllTitles();

    // przyklad surowego wyniku zapytania
    @Query(value = "select b.id, b.title from EntityBook b",nativeQuery = false)
    List<Object[]> getIdAndTitles();
    }

