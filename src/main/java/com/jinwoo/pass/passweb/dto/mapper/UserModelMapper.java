package com.jinwoo.pass.passweb.dto.mapper;

import com.jinwoo.pass.passweb.dto.User;
import com.jinwoo.pass.passweb.repository.Entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserModelMapper {
    UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    User toUser(UserEntity userEntity);
}
