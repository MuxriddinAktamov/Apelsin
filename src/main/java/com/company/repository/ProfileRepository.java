package com.company.repository;

import com.company.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer>, JpaSpecificationExecutor<ProfileEntity> {


    Optional<ProfileEntity> findByLoginAndPswd(String login, String pswd);

    Optional<ProfileEntity> findByLogin(String login);


}
