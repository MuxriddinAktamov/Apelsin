package com.company.config;

import com.company.entity.ProfileEntity;
import com.company.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailServise implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Optional<ProfileEntity> optional = profileRepository.findByLogin(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("user Not found");
        }
        ProfileEntity profile = optional.get();
        System.out.println(username);
        return new CustomUserDetail(profile);
    }
}
