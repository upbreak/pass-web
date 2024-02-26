package com.jinwoo.pass.passweb.service;

import com.jinwoo.pass.passweb.dto.BulkPass;
import com.jinwoo.pass.passweb.dto.mapper.BulkPassModelMapper;
import com.jinwoo.pass.passweb.dto.request.BulkPassRequest;
import com.jinwoo.pass.passweb.dto.type.BulkPassStatus;
import com.jinwoo.pass.passweb.repository.BulkPassRepository;
import com.jinwoo.pass.passweb.repository.Entity.BulkPassEntity;
import com.jinwoo.pass.passweb.repository.Entity.PackageEntity;
import com.jinwoo.pass.passweb.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BulkPassService {

    private final BulkPassRepository bulkPassRepository;
    private final PackageRepository packageRepository;

    public List<BulkPass> getAllBulkPasses() {
        List<BulkPassEntity> bulkPassEntities = bulkPassRepository.findAllOrderByStartedAtDesc();

        return BulkPassModelMapper.INSTANCE.map(bulkPassEntities);
    }

    public void addBulkPass(BulkPassRequest request){
        PackageEntity packageEntity = packageRepository.findById(request.getPackageSeq()).orElseThrow();

        BulkPassEntity bulkPassEntity = BulkPassModelMapper.INSTANCE.map(request);
        bulkPassEntity.setStatus(BulkPassStatus.READY);
        bulkPassEntity.setCount(packageEntity.getCount());
        bulkPassEntity.setEndedAt(packageEntity.getPeriod());

        bulkPassRepository.save(bulkPassEntity);

    }
}
