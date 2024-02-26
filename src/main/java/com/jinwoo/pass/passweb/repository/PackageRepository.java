package com.jinwoo.pass.passweb.repository;

import com.jinwoo.pass.passweb.repository.Entity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer> {

    List<PackageEntity> findAllByOrderByPackageName();
}
