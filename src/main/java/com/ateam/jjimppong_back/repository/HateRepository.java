package com.ateam.jjimppong_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ateam.jjimppong_back.common.entity.HateEntity;
import com.ateam.jjimppong_back.common.entity.pk.HatePK;

@Repository
public interface HateRepository extends JpaRepository<HateEntity, HatePK> {
    
}
