package com.example.cloneboard.Service;

import com.example.cloneboard.Dto.UserDeleteDto;
import com.example.cloneboard.Dto.UserRequestDto;
import com.example.cloneboard.Dto.UserResponseDto;
import com.example.cloneboard.Entity.BoardEntity;
import com.example.cloneboard.Entity.UserEntity;
import com.example.cloneboard.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public void createBoard(UserRequestDto userRequestDto) {
        userRepository.save(userRequestDto.toEntity());
    }

    public List<UserEntity> viewBoardList() {
        return userRepository.findAll();
    }

    public String viewNickname(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userEntity.getNickname();
    }

    public UserResponseDto viewBoard(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .email(userEntity.getEmail())
                .nickname(userEntity.getNickname())
                .password(userEntity.getPassword())
                .introduce(userEntity.getIntroduce())
                .build();

        return userResponseDto;
    }

    public void updateBoard(UserRequestDto userRequestDto) {
        UserEntity userEntity = userRepository.findByNickname(userRequestDto.getNickname());
        userEntity.update(userRequestDto);
        userRepository.save(userEntity);
    }

    public void deletedBoard(UserDeleteDto dto) { // 2개 뜨면 에러 뜸 //query did not return a unique result: 2; nested exception is javax.persistence.NonUniqueResultException: query did not return a unique result: 2
        UserEntity userEntity = userRepository.findByNickname(dto.getNickname());
        userRepository.delete(userEntity);
    }



}
