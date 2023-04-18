package com.example.cloneboard.Entity;

import com.example.cloneboard.Dto.BoardRequestDto;
import lombok.*;

import javax.persistence.*;
@Entity // 데이터베이스 필드와 여러 엔티티 간 연관관계 정의
@RequiredArgsConstructor
@Getter
@Builder // 빌더를 사용할 수 있게 함
@Table(name = "board") // 어노테이션
@AllArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @Column(nullable = false)
    private String nickname;

    public void update(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.nickname = boardRequestDto.getNickname();
        this.content = boardRequestDto.getContent();
    }

}
