package pl.sda.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springproject2.entity.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
