package com.example.cloneboard.Dto;

import com.example.cloneboard.Entity.UserEntity;
import com.example.cloneboard.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private String email, password, nickname, introduce, role;

//    public UserResponseDto(UserEntity entity) {
//        this.email = entity.getEmail();
//        this.password = entity.getPassword();
//        this.nickname = entity.getNickname();
//        this.introduce = entity.getIntroduce();
//        this.role = entity.getRole();
//    }

}
