package com.myBookSchelf.BookSchelf.security;

import com.myBookSchelf.BookSchelf.model.User;
import com.myBookSchelf.BookSchelf.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userOrEmail) throws UsernameNotFoundException {
      User user = userRepository.findByNameOrEmail(userOrEmail, userOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"+ userOrEmail));

      Set<GrantedAuthority> authorities = user.getRoles()
              .stream()
              .map((role ->
              new SimpleGrantedAuthority(role.getName()))).collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),authorities);
    }
}
