package pl.sda.springproject2.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDate;
@Data
@Builder
public class DomainTodo {
    private long id;
    private String title;
    private LocalDate deadline;
    private String person;
    private boolean completed;
    private Timestamp created;
}
