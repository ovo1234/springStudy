package com.example.cloneboard.Dto;

import com.example.cloneboard.Entity.BoardEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data // get, set 둘 다 됨.
@RequiredArgsConstructor
public class BoardRequestDto {
    private Long id;
    private String title, content, nickname;

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .title(title)
                .nickname(nickname)
                .content(content)
                .build();
    }

    @Override
    public String toString() {
        return "BoardDto{" + "title=" + title + ", content=" + content + ", nickname=" + nickname + '}';
    }

}
