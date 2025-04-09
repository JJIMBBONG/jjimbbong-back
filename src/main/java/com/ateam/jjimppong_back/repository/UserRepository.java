package com.ateam.jjimppong_back.repository;

import com.ateam.jjimppong_back.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
    
    boolean existsByUserId(String userId);
    boolean existsByUserNickname(String userNickname);

}
