package com.example.cloneboard.Entity;

import com.example.cloneboard.Dto.BoardRequestDto;
import com.example.cloneboard.Dto.UserRequestDto;
import com.example.cloneboard.Model.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity // 데이터베이스 필드와 여러 엔티티 간 연관관계 정의
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Builder // 빌더를 사용할 수 있게 함
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private String introduce;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public void update(UserRequestDto userRequestDto) {
        this.email = userRequestDto.getEmail();
        this.password = userRequestDto.getPassword();
        this.nickname = userRequestDto.getNickname();
        this.introduce = userRequestDto.getIntroduce();
    }

}