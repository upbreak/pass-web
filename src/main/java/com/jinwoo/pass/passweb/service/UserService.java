package com.jinwoo.pass.passweb.service;

import com.jinwoo.pass.passweb.dto.User;
import com.jinwoo.pass.passweb.dto.mapper.UserModelMapper;
import com.jinwoo.pass.passweb.repository.Entity.UserEntity;
import com.jinwoo.pass.passweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(String userId){
        UserEntity userEntity = userRepository.findByUserId(userId);

        return UserModelMapper.INSTANCE.toUser(userEntity);
    }
}
