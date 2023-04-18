package com.example.cloneboard.Repository;

import com.example.cloneboard.Entity.BoardEntity;
import com.example.cloneboard.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByNickname(String nickname);
    UserEntity findByEmail(String email);
}
