package com.example.cloneboard.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDeleteDto {
    private Long id;
    private String email, password, nickname, introduce;

}
