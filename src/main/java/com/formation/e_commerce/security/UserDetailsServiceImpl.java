package com.formation.e_commerce.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

import com.formation.e_commerce.model.Personne;
import com.formation.e_commerce.service.AccountService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
     private AccountService accountService;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
             Personne  personne= accountService.loadUserByUsername(username);
            if (personne == null) throw new UsernameNotFoundException("invalid user");
            Collection<GrantedAuthority> authorities = new ArrayList<>();

          
                authorities.add(new SimpleGrantedAuthority(personne.getRole().getRoleName()));
            
            return new User(personne.getUserName(), personne.getPassword(), authorities);
        }
}