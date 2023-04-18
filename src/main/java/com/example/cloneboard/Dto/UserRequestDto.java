package com.example.cloneboard.Dto;

import com.example.cloneboard.Entity.UserEntity;
import com.example.cloneboard.Entity.UserPasswordSecurity;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data // get, set 둘 다 됨.
@RequiredArgsConstructor
public class UserRequestDto {
    private String email, password, nickname, introduce,role;

    public UserEntity toEntity() {
        UserPasswordSecurity webSecurityConfig = new UserPasswordSecurity();

        return UserEntity.builder()
                .email(email)
                .password(webSecurityConfig.getPasswordEncoder().encode(password))
                .nickname(nickname)
                .introduce(introduce)
                .role("User")
                .build();
    }

}
