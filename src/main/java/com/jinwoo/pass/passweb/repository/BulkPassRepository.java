package com.jinwoo.pass.passweb.repository;

import com.jinwoo.pass.passweb.repository.Entity.BulkPassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BulkPassRepository extends JpaRepository<BulkPassEntity, Integer> {

    @Query(value = "select b from BulkPassEntity b " +
            "order by b.startedAt desc")
    List<BulkPassEntity> findAllOrderByStartedAtDesc();
}
