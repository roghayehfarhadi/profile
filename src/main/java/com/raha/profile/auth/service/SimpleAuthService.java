package com.raha.profile.auth.service;

import com.raha.profile.auth.dtos.TokenDto;
import com.raha.profile.auth.dtos.Logging;
import com.raha.profile.auth.security.token.TokenHelper;
import com.raha.profile.user.exception.NotFoundException;
import com.raha.profile.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleAuthService implements AuthService {

    private final UserRepository userRepository;
    private final TokenHelper tokenHelper;

    @Override
    public TokenDto loginUser(Logging logging) {
        return userRepository.findByUserNameAndPassword(logging.getUserName(), logging.getPassword())
                .map(usrInfo -> tokenHelper.generateUserTokenDto(usrInfo.getId()))
                .orElseThrow(NotFoundException::new);
    }
}
