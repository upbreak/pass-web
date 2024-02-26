package com.jinwoo.pass.passweb.service;

import com.jinwoo.pass.passweb.dto.Package;
import com.jinwoo.pass.passweb.dto.mapper.PackageModelMapper;
import com.jinwoo.pass.passweb.repository.Entity.PackageEntity;
import com.jinwoo.pass.passweb.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageService {

    private final PackageRepository packageRepository;
    public List<Package> getAllPackages() {
        List<PackageEntity> packageEntities = packageRepository.findAllByOrderByPackageName();

        return PackageModelMapper.INSTANCE.map(packageEntities);
    }
}
