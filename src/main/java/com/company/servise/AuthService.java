package com.company.servise;


import com.company.dto.AuthorizationDTO;
import com.company.dto.ProfileDTO;
import com.company.entity.ProfileEntity;
import com.company.enums.ProfileStatus;
import com.company.repository.ProfileRepository;
import com.company.util.JwtUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private ProfileRepository profileRepository;


    public ProfileDTO authorization(AuthorizationDTO dto) throws BadAttributeValueExpException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(dto.getPassword());

        Optional<ProfileEntity> optional = profileRepository.findByLogin(dto.getLogin());
        if (!optional.isPresent()) {
            throw new RuntimeException("Login or Password incorrect");
        }
        if (!encoder.matches(dto.getPassword(), optional.get().getPswd())) {
            throw new UsernameNotFoundException("Login or Password incorrect");
        }
        System.out.println(encoder.matches(dto.getPassword(), password));

//        Optional<ProfileEntity> optional = profileRepository
//                .findByLoginAndPswd(dto.getLogin(), password);
//        if (!optional.isPresent()) {
//            throw new RuntimeException("Login or Password incorrect");
//        }
//        if (!optional.get().getStatus().equals(ProfileStatus.ACTIVE)) {
//            throw new BadAttributeValueExpException("You are Not Alowed");
//        }
        String jwt = JwtUtil.createJwt(optional.get().getId(), optional.get().getLogin());

        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setName(optional.get().getName());
        profileDTO.setSurname(optional.get().getSurname());
//        profileDTO.setPhone(optional.get().getPhone());
        profileDTO.setLogin(optional.get().getLogin());
//        profileDTO.setPswd(optional.get().getPswd());
//        profileDTO.setStatus(optional.get().getStatus());
        profileDTO.setJwt(jwt);
        return profileDTO;
    }

    public ProfileDTO registration(ProfileDTO dto) throws BadAttributeValueExpException {

        if (profileRepository.findByLogin(dto.getLogin()).isPresent()) {
            throw new BadAttributeValueExpException("Login already exists");
        }

        ProfileEntity profileDTO = new ProfileEntity();
        profileDTO.setName(dto.getName());
        profileDTO.setSurname(dto.getSurname());
        profileDTO.setLogin(dto.getLogin());

        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        profileDTO.setPswd(b.encode(dto.getPswd()));

        profileDTO.setPhone(dto.getPhone());
        profileDTO.setRole(dto.getRole());
        profileDTO.setStatus(ProfileStatus.ACTIVE);
        profileDTO.setCreatedDate(LocalDateTime.now());

        profileRepository.save(profileDTO);
        dto.setId(profileDTO.getId());

        return dto;
    }


}
