package pl.sda.springproject2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // sygnal ze w tej adnotacji beda generowane tylko te pola
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include //adnotacja tylko dla pola id
    private long id;

    private String firstName;

    private String lastName;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    private Set<Article> articles;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
