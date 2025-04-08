package com.ateam.jjimppong_back.repository;

import com.ateam.jjimppong_back.common.entity.EmailAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailAuthRepository extends JpaRepository<EmailAuthEntity, String>{
    
}
