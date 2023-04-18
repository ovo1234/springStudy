package com.example.cloneboard.Service;

import com.example.cloneboard.Dto.BoardDeleteDto;
import com.example.cloneboard.Dto.BoardRequestDto;
import com.example.cloneboard.Dto.BoardResponseDto;
import com.example.cloneboard.Entity.BoardEntity;
import com.example.cloneboard.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(BoardRequestDto boardRequestDto) {
        boardRepository.save(boardRequestDto.toEntity());
    }

    public List<BoardEntity> viewBoardList() {
        return boardRepository.findAll();
    }

//    public List<BoardResponseDto> viewBoardList() {
//        List<BoardEntity> entityList = boardRepository.findAll();
//        return entityList.stream()
//                .map(e -> new BoardResponseDto(e.getTitle(), e.getNickname(), e.getContent()))
//                .collect(Collectors.toList());
//    }

    public BoardResponseDto viewBoard(String nickname) {
        BoardEntity boardEntity = boardRepository.findByNickname(nickname);
        BoardResponseDto boardResponseDto = BoardResponseDto.builder()
                .title(boardEntity.getTitle())
                .nickname(boardEntity.getNickname())
                .content(boardEntity.getContent())
                .build();


        return boardResponseDto;
    }

    public void updateBoard(BoardRequestDto boardRequestDto) {
        BoardEntity boardEntity = boardRepository.findByNickname(boardRequestDto.getNickname());
        boardEntity.update(boardRequestDto);
        boardRepository.save(boardEntity);
    }

    public void deletedBoard(BoardDeleteDto dto) { // 2개 뜨면 에러 뜸 //query did not return a unique result: 2; nested exception is javax.persistence.NonUniqueResultException: query did not return a unique result: 2
        BoardEntity boardEntity = boardRepository.findByNickname(dto.getNickname());
        boardRepository.delete(boardEntity);
    }
}