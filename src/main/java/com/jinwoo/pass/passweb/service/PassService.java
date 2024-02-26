package com.jinwoo.pass.passweb.service;

import com.jinwoo.pass.passweb.dto.Pass;
import com.jinwoo.pass.passweb.dto.mapper.PassModelMapper;
import com.jinwoo.pass.passweb.repository.Entity.PassEntity;
import com.jinwoo.pass.passweb.repository.PassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PassService {

    private final PassRepository passRepository;

    public List<Pass> getPasses(String userId){
        List<PassEntity> passEntities = passRepository.findByUserId(userId);

        return PassModelMapper.INSTANCE.map(passEntities);
    }
}
