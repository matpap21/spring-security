package pl.sda.springproject2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long id;
    @NotBlank
    @Length(min=1,max=120,message = "Dlugosc musi max 120")
    private String title;
    @Length(min=3,max=15,message = "Dlugosc musi zawierac min 3 , max 15")
    private String author;

}
