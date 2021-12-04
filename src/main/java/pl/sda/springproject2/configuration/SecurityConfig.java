package pl.sda.springproject2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter { // ctrl + o -- > zobaczyc mozna metody jakie mozna wybrac
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // reguly sa przetwarzane od gory do dolu i kolejnosc ,ma znaczenie
        http
               // .httpBasic()
              //  .realmName("spring")
              //  .and()
                .csrf()
                .disable()
                .headers()
                .and()
                .authorizeRequests()
               // .antMatchers("/todo/**", "/person/**").authenticated()
                // USER ma dostep do /todo/list , ale nie ma dostepu do /todo/add
                //ADMIN ma dostep do /todo/**
                .antMatchers("/todo/list").hasAnyRole("USER","ADMIN")
                .antMatchers("/todo/**", "/person/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.PATCH,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/api/v2/todos").permitAll()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and();

    }
    // zaznacz blok + ctrl + slash
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("$2a$12$UKYmzmTSLqJ..Xotk3KrcOMx03bo28P1UMtgsGOzeS5gLxo6BvQIi").roles("USER","ADMIN").and()
//                .withUser("ktos").password("ktos").roles("USER").and()
//                .withUser("admin").password("admin").roles("ADMIN");
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    @Bean // potrzebny by przekodowac password jako haslo a nie jako skrot
    public PasswordEncoder encoder(){
       // return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}
