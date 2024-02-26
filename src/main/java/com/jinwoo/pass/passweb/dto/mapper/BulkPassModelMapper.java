package com.jinwoo.pass.passweb.dto.mapper;

import com.jinwoo.pass.passweb.dto.BulkPass;
import com.jinwoo.pass.passweb.dto.request.BulkPassRequest;
import com.jinwoo.pass.passweb.repository.Entity.BulkPassEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BulkPassModelMapper {
    BulkPassModelMapper INSTANCE = Mappers.getMapper(BulkPassModelMapper.class);

    List<BulkPass> map(List<BulkPassEntity> bulkPassEntities);

    BulkPassEntity map(BulkPassRequest request);
}
