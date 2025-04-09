package com.ateam.jjimppong_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ateam.jjimppong_back.common.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
  
  boolean existsByUserId(String userId);
  boolean existsByUserEmail(String userEmail);

  UserEntity findByUserId(String userId);

}
