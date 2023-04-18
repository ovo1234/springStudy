package com.example.cloneboard.Repository;

import com.example.cloneboard.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// repository : 엔티티에 의해 생성된 db에 접근하는 메서드들을 사용하기 위한 인터페이스

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> { // JPA 사용 -> save(), findAll() 등 기본적 메서드 사용 가능
    BoardEntity findByNickname(String nickname);
//    BoardResponseDto findByNickname(String nickname);
}
