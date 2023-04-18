package com.example.cloneboard.Controller;

import com.example.cloneboard.Dto.BoardDeleteDto;
import com.example.cloneboard.Dto.BoardRequestDto;
import com.example.cloneboard.Dto.BoardResponseDto;
import com.example.cloneboard.Entity.BoardEntity;
import com.example.cloneboard.Repository.BoardRepository;
import com.example.cloneboard.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("/")
    public ResponseEntity<String> createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.createBoard(boardRequestDto);
        return ResponseEntity.ok("게시글이 등록되었습니다.");
    }

    @GetMapping("/")
    public List<BoardEntity> viewBoardList() {
        return boardService.viewBoardList();
    }

    @GetMapping("/board")
    public BoardResponseDto viewBoard(@RequestParam String nickname) {
        return boardService.viewBoard(nickname);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateBoard(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.updateBoard(boardRequestDto);
        return ResponseEntity.ok("게시글이 수정되었습니다.");
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deletedBoard(@RequestBody BoardDeleteDto dto) {
        boardService.deletedBoard(dto);
        return ResponseEntity.ok("게시글이 삭제되었습니다.");
    }
}