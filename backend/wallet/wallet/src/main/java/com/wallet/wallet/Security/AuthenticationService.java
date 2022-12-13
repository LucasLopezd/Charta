package com.wallet.wallet.Security;

import com.wallet.wallet.api.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final IUserService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = service.getByEmail(email);

        var grantedAuthority = new SimpleGrantedAuthority(user.getRole().name());

        return new User(user.getEmail(), user.getPassword(), List.of(grantedAuthority));
    }
}
