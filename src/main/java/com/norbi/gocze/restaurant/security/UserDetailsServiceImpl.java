package com.norbi.gocze.restaurant.security;


import com.norbi.gocze.restaurant.entity.SecuUser;
import com.norbi.gocze.restaurant.repository.SecuUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SecuUserRepository secuUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecuUser secuUser = secuUserRepository
                .findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new User(
                secuUser.getUserName(),
                secuUser.getHashedPassword(),
                secuUser.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                        .collect(Collectors.toList())
        );
    }
}
