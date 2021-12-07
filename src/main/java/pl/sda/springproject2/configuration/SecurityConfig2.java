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

//Configuration
public class SecurityConfig2 extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfig2(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .headers()
                .and()
                .authorizeRequests()
                .antMatchers("/todo/list").hasAnyRole("USER", "ADMIN") //
                .antMatchers("/todo/**", "/person/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.PATCH,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/api/v2/todos/**").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and();

    }
        // zablokowac ten blok gdy uzywamy SecureConfig3
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(encoder());
//    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();

        // zablokowac ten blok gdy uzywamy SecureConfig3
    }
}
