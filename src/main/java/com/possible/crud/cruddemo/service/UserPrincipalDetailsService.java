package com.possible.crud.cruddemo.service;

import com.possible.crud.cruddemo.entities.UserPrincipal;
import com.possible.crud.cruddemo.entities.User;
import com.possible.crud.cruddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void userRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    //this help to retrieve(get) user-related data from db
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        //user.orElseThrow(() -> new UsernameNotFoundException ("Not found: " + userName));
        return user.map(UserPrincipal::new).get();


    }
}
