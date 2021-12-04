package pl.sda.springproject2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import pl.sda.springproject2.model.Book;

import javax.validation.constraints.NotBlank;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewBookDto{
    private long id;
    private String title;
    private String author;
}
