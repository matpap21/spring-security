package pl.sda.springproject2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String title;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) // cascada powoduje, ze jezeli usune element nadrzedny to usuna sie rowniez elementy podrzedne
    // czyli te ktorych wartosci sa kluczami obcymi
    // czyli autor b ma swoj klucz podrzedny przypisany do artykulu,
    // jesli usuniemy teraz autora to cascada delete spowoduje ze automatycznie zostana skasowane wszystkie artykuly tego autora
    // (a wiec jaki jest sens trzymania w bazie artykulow nieznanego autoa, ktorego nie ma)

    // CascadePERSIST powoduje, ze jezeli bedziemy mieli nowego autora. ktory nie byl zapamietany to nie musimy go dodawac do repozytorium
    // zostanie ten autor automatycznie utrwalony , cascada ta sprawi, ze latwo bedzie nam dodawac artykuly

    // Cascade dotyczy zwiazku pomiedzy kluczem glownym a kluczem obcym (jezeli usune obiekt nadrzedny to cascada spowoduje usuniecie obiektu podrzednego)
    // Cascada persist, jezeli dodaje tutyl ksiazki do autora, ktorego jeszcze nie ma to powoduje, ze autor zostanie utworzony (dodany do bazy)
    // i dopiero potem zostanie jego klucz glowny umieszczony w Autorze i doda tytuly z wartoscia klucza obcego do Autora
    // kaskadowo cos sie dzieje, gdy dodamy rekord, usuwamy rekord, update rekord
    private Set<Author> authors;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
