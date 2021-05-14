package com.raha.profile.auth;

import com.raha.profile.auth.dtos.LoginDto;
import com.raha.profile.auth.dtos.TokenDto;
import com.raha.profile.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static com.raha.profile.utility.UrlMappings.LOGIN;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(LOGIN)
    public TokenDto login(@RequestBody @Valid LoginDto loginDto) {
        return authService.loginUser(loginDto.toLogging());
    }
}
