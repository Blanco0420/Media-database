package com.media.database.media_database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.media.database.media_database.models.UserInfo;
import com.media.database.media_database.repositories.UserInfoRepository;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userDetail = repository.findByUsername(username); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        // return userDetail.map(UserInfoDetails::new)
        //         .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        UserInfo userInfo = userDetail.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new UserInfoDetails(userInfo);
    }

    public boolean  addUser(UserInfo userInfo) {
        // Encode password before saving the user
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        try{
        repository.save(userInfo);
        return true;
        }
        catch(Exception e){
            System.out.println("Error in saving user: " + e.getMessage());
            throw e;
        }
    }
}
