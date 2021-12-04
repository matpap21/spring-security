package pl.sda.springproject2.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EntityBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)// wymuszanie, nie jest koniecznie dodawanie, daje mozliwosc ograniczenia po stronie bazy
    private String title;
    @Column(nullable = false)// wymuszanie
    private String author;


}

