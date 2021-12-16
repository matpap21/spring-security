package pl.sda.springproject2.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Entity
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String password;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    private boolean enable; // domyslnie jest false

    private String role; // ROLE_USER , ROLE_ADMIN, to co wyciagamy z pola ROLE to bedzie lancuch ktory trzeba bedzie sobie podzielic, czyli
    // nie mozemy zwracac  Collection z jednym elementem, tylko chcemy miec kolekcje lancuchow

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
     return Arrays.stream(role.split(" "))
                .map(r-> {
                   GrantedAuthority authority =  () -> r;
                   return authority;
                })
                .collect(Collectors.toList());
      //  return Collections.singleton(() -> role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
