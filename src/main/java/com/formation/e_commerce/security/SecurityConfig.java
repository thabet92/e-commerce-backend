package com.formation.e_commerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login", "/home/**", "/").permitAll();//tous permet creer login et register
        http.authorizeRequests().antMatchers("/utilisateur/**", "/roles/**").permitAll();
        //  http.authorizeRequests().antMatchers("/user/**").hasAuthority("ADMIN");//
        http.authorizeRequests().antMatchers("/user/byiduser/**").permitAll();


        http.authorizeRequests().antMatchers("/candidat/**").permitAll();

        http.authorizeRequests().antMatchers("/res/reservations","/res/validerreservation/**","/res/resrvationaccepter/**","/res/reservationenattend/**","/res/deleteresrvation/**","/res/deleteresrvationnovalid/**").permitAll();
        http.authorizeRequests().antMatchers("/responsableCentre/**").permitAll();
        http.authorizeRequests().antMatchers("/societe/**").permitAll();
        http.authorizeRequests().antMatchers("/image/**").permitAll();
        http.authorizeRequests().antMatchers("/Admin/**").permitAll();
        http.authorizeRequests().antMatchers("/annonce/all").permitAll();
        http.authorizeRequests().antMatchers("/secteur/**").permitAll();
        http.authorizeRequests().antMatchers("/annonce/add/**").hasAuthority("CONDUCTEUR");
        http.authorizeRequests().antMatchers("/annonce/edit/**").hasAuthority("CONDUCTEUR");
        http.authorizeRequests().antMatchers("/formation/**").permitAll();
        http.authorizeRequests().antMatchers("/stage/**").permitAll();
        http.authorizeRequests().antMatchers("/travaille/**").permitAll();
        http.authorizeRequests().antMatchers("/favorie/**").permitAll();
        http.authorizeRequests().antMatchers("/commentaire/**").permitAll();
        http.authorizeRequests().antMatchers("/role/**").permitAll();


        http.authorizeRequests().antMatchers("/articles/**").permitAll();
        http.authorizeRequests().antMatchers("/categories/**").permitAll();
        http.authorizeRequests().antMatchers("/clients/**").permitAll();
        http.authorizeRequests().antMatchers("/commandes/**").permitAll();
        http.authorizeRequests().antMatchers("/fournisseur/**").permitAll();
        http.authorizeRequests().antMatchers("/reclamations/**").permitAll();
        http.authorizeRequests().antMatchers("/souscategories/**").permitAll();
        http.authorizeRequests().antMatchers("/responsablesVente/**").permitAll();
        http.authorizeRequests().antMatchers("/administrateurs/**").permitAll();
        http.authorizeRequests().antMatchers("/upload/**").permitAll();

    


        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
    }
}
