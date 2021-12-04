package pl.sda.springproject2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
@Data
@Builder
@NoArgsConstructor // musi byc konstruktor bezargumentowy dla Springa by otworzyc nam ten obiekt
@AllArgsConstructor
// skrot Dto -- > postac danych od klienta(fomularz) przed dodaniem do systemu /bazy (przed zarejestrowaniem, przepisania i dodania do systemu)
public class NewTodoDto { // tdo -- > data transfer obcjet
    @NotBlank // oznacza, ze nie moze byc pusty
    private String title;
    @Length(min=10, max =10, message = "Podaj date w forcmacie YYYY-MM-DD i dokladnie 10 znakow, nie wiecej, nie mniej")
    private String deadline;
    @NotNull
    @NotBlank
    private String person;

}
