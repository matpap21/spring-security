package pl.sda.springproject2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    private long id;
    private String title;
    private String deadline;
    private String person;
    private boolean completed;
    private Timestamp created;

   // public LocalDate getDeadLine(){
     //   return LocalDate.parse(deadline);

  //  }

}
