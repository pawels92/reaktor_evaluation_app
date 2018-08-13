package com.evaluation.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //które z podstron wymgają autoryzacji
                //.antMatchers ("/contact")
                //jakich wymagają uprawnień
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .failureUrl("/errorPage")
                .defaultSuccessUrl("/")
                .failureUrl("/errorPage")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery("SELECT email, password, active FROM user WHERE email = ?")
                .authoritiesByUsernameQuery("SELECT u.email, r.role_name FROM user u JOIN role ur ON ur.id = u.id JOIN role r ON ur.id = r.id WHERE u.email = ?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);

    }
}
