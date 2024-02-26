package com.jinwoo.pass.passweb.repository;

import com.jinwoo.pass.passweb.repository.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUserId(String userId);
}
