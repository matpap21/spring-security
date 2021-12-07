package pl.sda.springproject2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ponizej autoryzacja na podstawie sesji bez .httpBasic(), stosowane w aplikacjach mvc , czyli tych, które zwracają strony
        // kazde ciastko ma okreslony czas zycia tzw "max age" ?
        // spring raz wyswietla nam formularz, nie korzysta z naglowka autorization tylko formularz przesyla nam dane do atoryzacji
        // spring na serwerze tworzy nam sesje, zapamietuje uzytkownika i kazdy nastepny request ze strony formularza musi zawierac sesion id
        http
               // .httpBasic() // jesli to uzyjemy to znikna nam formularze logowania, przegladarka owtorzy nam okienko z podaniem hasla i zutkownika
                // zapamieta dane autoryzacyjne i przegldarka juz wysyla w kazdym requescie naglowek autorization

              //  .realmName("spring") // nazwa krolestwa zabezpieczen
              //  .and()
                .csrf() // zabezpieczenia
                .disable()
                .headers()
                .and()
                .authorizeRequests()
                //.antMatchers("/todo/**", "/person/**").authenticated() // konfiguracja sciezek, wszystkie sciezki ktore maja wspolna polityke powinny byc dodwawane do tej metody
                .antMatchers("/todo/list").hasAnyRole("USER", "ADMIN") //
                .antMatchers("/todo/**", "/person/**").hasRole("ADMIN")
                // ograniczamy
                .antMatchers(HttpMethod.PUT,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.PATCH,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/api/v2/todos/**").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
              //  .loginPage()
              //  .defaultSuccessUrl("/")
                .and()
                .logout()
              //  .clearAuthentication(true)
                .logoutSuccessUrl("/")
                .and();


    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("matpap21@wp.pl").password("spring").roles("USER","ADMIN")
//                .and()
//                .withUser("ktos").password("ktos").roles("USER")
//                .and()
//                .withUser("user").password("spring").roles("ADMIN");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("matpap21@wp.pl").password("$2a$12$9njK38D7aJZ.lrtXcVTna.QOs0t1f69HfP4tGqqK8leCjyLCtlKwK").roles("USER","ADMIN")
                .and()
                .withUser("ktos").password("$2a$12$3pgQeMFQpamAISHdX.jxWeoA5VHJ23hjuATUOKcdqk.r69nR7rv06").roles("USER")
                .and()
                .withUser("user").password("$2a$12$9njK38D7aJZ.lrtXcVTna.QOs0t1f69HfP4tGqqK8leCjyLCtlKwK").roles("ADMIN");
    }
    @Bean
    public PasswordEncoder encoder(){
       // return  NoOpPasswordEncoder.getInstance(); // hasla ustawione na sztywno
        return new BCryptPasswordEncoder(); // hasla zakryptowne https://bcrypt-generator.com/
    }

}
