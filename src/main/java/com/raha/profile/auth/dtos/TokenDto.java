package com.raha.profile.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenDto {
    private Long userId;
    private String accessToken;
    private String refreshToken;
    private Integer accessExpiration;
    private Integer refreshExpiration;
}
