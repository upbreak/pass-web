package com.jinwoo.pass.passweb.repository.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate // 생성 일시를 생성합니다.
    @Column(updatable = false, nullable = false) // 업데이트를 하지 않도록, null이 되지 않도록 명시합니다.
    private LocalDateTime createdAt;
    @LastModifiedDate // 마지막 수정 일시를 생성합니다.
    private LocalDateTime modifiedAt;
}
