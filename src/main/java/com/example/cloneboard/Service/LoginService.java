package com.example.cloneboard.Service;

import com.example.cloneboard.Dto.UserRequestDto;
import com.example.cloneboard.Entity.UserEntity;
import com.example.cloneboard.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.sql.RowSet;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    public boolean login(UserRequestDto userRequestDto) {

        UserEntity findUser = userRepository.findByEmail(userRequestDto.getEmail());

        if(findUser == null){
            System.out.println("id null");
            return false;
        }

        if(!findUser.getPassword().equals(userRequestDto.getPassword())){
            System.out.println("pw null or not match");
            return false;
        }

        return true;

    }


}
