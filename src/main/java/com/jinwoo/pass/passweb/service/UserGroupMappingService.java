package com.jinwoo.pass.passweb.service;

import com.jinwoo.pass.passweb.repository.Entity.UserGroupMappingEntity;
import com.jinwoo.pass.passweb.repository.UserGroupMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGroupMappingService {

    private final UserGroupMappingRepository userGroupMappingRepository;
    public List<String> getAllUserGroupIds() {
        return userGroupMappingRepository.findDistinctUserGroupId();
    }
}
