package pl.sda.springproject2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "todos")
public class EntityToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)// wymuszanie, nie jest koniecznie dodawanie, daje mozliwosc ograniczenia po stronie bazy
    private String title;
    @Column(nullable = false)// wymuszanie
    private LocalDate deadline;
    @Column(nullable = false)// wymuszanie
    private String person;
    @Column(nullable = false)// wymuszanie
    private boolean completed;
    @CreationTimestamp // to pole zostaje zainicjowane w momencie utowrzenia rekordu w bazie danych
    private Timestamp created;
}
