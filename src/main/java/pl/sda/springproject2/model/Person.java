package pl.sda.springproject2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private double salary;
    private String pesel;
    private boolean available;
}
