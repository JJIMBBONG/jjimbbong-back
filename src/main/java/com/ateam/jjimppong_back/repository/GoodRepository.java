package com.ateam.jjimppong_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ateam.jjimppong_back.common.entity.GoodEntity;
import com.ateam.jjimppong_back.common.entity.pk.GoodPK;

@Repository
public interface GoodRepository extends JpaRepository<GoodEntity, GoodPK> {

}
