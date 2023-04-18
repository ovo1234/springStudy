package com.example.cloneboard.Dto;

import com.example.cloneboard.Entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponseDto {
    private String title;
    private String nickname;
    private String content;

}