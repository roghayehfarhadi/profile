package com.raha.profile.auth.service;

import com.raha.profile.auth.dtos.TokenDto;
import com.raha.profile.auth.dtos.Logging;

public interface AuthService {

    TokenDto loginUser(Logging logging);
}
