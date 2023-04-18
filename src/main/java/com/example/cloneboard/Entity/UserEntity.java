package com.example.cloneboard.Entity;

import com.example.cloneboard.Dto.BoardRequestDto;
import com.example.cloneboard.Dto.UserRequestDto;
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

    @Column
    private String role;

    public void update(UserRequestDto userRequestDto) {
        this.email = userRequestDto.getEmail();
        this.password = userRequestDto.getPassword();
        this.nickname = userRequestDto.getNickname();
        this.introduce = userRequestDto.getIntroduce();
        this.role = userRequestDto.getRole();
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        for(String role : role.split(",")){
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}