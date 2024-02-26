package com.jinwoo.pass.passweb.dto.mapper;

import com.jinwoo.pass.passweb.dto.Package;
import com.jinwoo.pass.passweb.repository.Entity.PackageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PackageModelMapper {
    PackageModelMapper INSTANCE = Mappers.getMapper(PackageModelMapper.class);

    List<Package> map(List<PackageEntity> packageEntity);
}
