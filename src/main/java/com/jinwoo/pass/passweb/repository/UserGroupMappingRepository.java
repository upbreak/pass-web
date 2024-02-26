package com.jinwoo.pass.passweb.repository;

import com.jinwoo.pass.passweb.repository.Entity.UserGroupMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserGroupMappingRepository extends JpaRepository<UserGroupMappingEntity, Integer> {

    @Query(value = "select distinct u.userGroupId " +
            "from UserGroupMappingEntity u " +
            "order by u.userGroupId")
    List<String> findDistinctUserGroupId();
}
