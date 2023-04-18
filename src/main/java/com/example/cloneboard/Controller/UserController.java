package com.example.cloneboard.Controller;

import com.example.cloneboard.Dto.*;
import com.example.cloneboard.Entity.BoardEntity;
import com.example.cloneboard.Entity.UserEntity;
import com.example.cloneboard.Repository.BoardRepository;
import com.example.cloneboard.Repository.UserRepository;
import com.example.cloneboard.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<String> createBoard(@RequestBody UserRequestDto userRequestDto) {
        userService.createBoard(userRequestDto);
        return ResponseEntity.ok("회원가입이 되었습니다.");
    }

    @GetMapping("/user")
    public List<UserEntity> viewBoardList() {
        return userService.viewBoardList();
    }

    @GetMapping("/user/list")
    public UserResponseDto viewBoard(@RequestParam String email) {
        return userService.viewBoard(email);
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateBoard(@RequestBody UserRequestDto userRequestDto) {
        userService.updateBoard(userRequestDto);
        return ResponseEntity.ok("유저정보가 수정되었습니다.");
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> deletedBoard(@RequestBody UserDeleteDto dto) {
        userService.deletedBoard(dto);
        return ResponseEntity.ok("유저정보가 삭제되었습니다.");
    }

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/user/getTest")
//    public List<UserEntity> findAll() {
//        List<UserEntity> user = userService.findAll();
//        System.out.println("data : "+user);
//        return user;
//    }
//
//    @PostMapping("/user/postTest")
//    public UserEntity saveBoard(UserDto form) {
//        UserEntity user = new UserEntity();
//        user.setEmail(form.getEmail());
//        user.setPassword(form.getPassword());
//        user.setNickname(form.getNickname());
//        user.setIntroduce(form.getIntroduce());
//        System.out.println(form.toString());
//        return userService.saveUser(user);
//    }
//
//    @PostMapping("/user/updateTest")
//    public UserEntity updateUser(UserDto from){
//        Long id = from.getId();
//        String email = from.getEmail();
//        String password = from.getPassword();
//        String nickname = from.getNickname();
//        return userService.updateUser(id, email, password, nickname);
//    }
//
//    @PostMapping("/user/deleteTest")
//    public void deleteBoard(BoardRequestDto form){
//        userService.deleteUser(form.getId());
//    }
}
