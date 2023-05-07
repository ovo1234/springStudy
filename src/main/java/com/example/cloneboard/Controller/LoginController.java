package com.example.cloneboard.Controller;

import com.example.cloneboard.Dto.UserRequestDto;
import com.example.cloneboard.Entity.UserEntity;
import com.example.cloneboard.Service.LoginService;
import com.example.cloneboard.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final UserService userService;

    //@PreAuthorize("hasRole('ROLE_USER')")
    //@Secured({"ROLE_USER"})
    @GetMapping("/loginUser/true")
    public String loginTrue() {
        return "loginTrue";
    }

    @GetMapping("/loginUser/fail")
    public String loginFail() {
        return "loginFalse";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "접근 권한이 없습니다.";
    }

    @PostMapping("/loginUser")
    public String loginPost(@RequestBody UserRequestDto userRequestDto) {
         if(loginService.login(userRequestDto)){
             // 권한을 동적으로 부여한다.
             List<GrantedAuthority> authorities = new ArrayList<>();
             authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

             UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userRequestDto.getEmail(), userRequestDto.getPassword(), authorities);
             SecurityContextHolder.getContext().setAuthentication(authToken);

             return userService.viewNickname(userRequestDto.getEmail()) + "님 환영합니다.";
         }
        return "로그인실패";
    }

}
