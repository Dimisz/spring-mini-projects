package com.uningen.cars.service;

import com.uningen.cars.domain.AppUser;
import com.uningen.cars.domain.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = appUserRepository.findByUsername(username);

        User.UserBuilder userbuilder = null;
        if(user.isPresent()){
            AppUser currentUser = user.get();

            userbuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            userbuilder.password(currentUser.getPassword());
            userbuilder.password(currentUser.getRole());
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
        return userbuilder.build();
    }
}
