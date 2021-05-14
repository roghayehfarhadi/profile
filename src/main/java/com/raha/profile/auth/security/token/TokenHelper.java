package com.raha.profile.auth.security.token;

import com.raha.profile.auth.dtos.TokenDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class TokenHelper {

    private final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
    private final JwtProperties jwtProperties;

    public TokenDto generateUserTokenDto(Long userId) {
        return new TokenDto(userId
                , generateToken(userId, jwtProperties.getIssuer(), JwtTokenType.ACCESS, generateTokeExpireDate(JwtTokenType.ACCESS))
                , generateToken(userId, jwtProperties.getIssuer(), JwtTokenType.REFRESH, generateTokeExpireDate(JwtTokenType.REFRESH))
                , jwtProperties.getAccess().getExpiration()
                , jwtProperties.getRefresh().getExpiration()
        );
    }

    private Date generateTokeExpireDate(JwtTokenType jwtTokenType) {
        if (jwtTokenType.name().equals(JwtTokenType.ACCESS.name()))
            return Date.from(LocalDateTime.now().plusMinutes(jwtProperties.getAccess().getExpiration())
                    .atZone(ZoneId.systemDefault()).toInstant());
        return java.sql.Date.valueOf(LocalDate.now().plusMonths(jwtProperties.getRefresh().getExpiration()));
    }

    private String generateToken(Long userId, String issuer, JwtTokenType jwtTokenType, Date expireDate) {
        return Jwts
                .builder()
                .setIssuer(issuer)
                .setSubject(userId.toString())
                .claim("t_type", jwtTokenType.name())
                .setIssuedAt(java.sql.Date.valueOf(LocalDate.now()))
                .setExpiration(expireDate)
                .signWith(SIGNATURE_ALGORITHM, jwtProperties.getSecret())
                .compact()
                ;
    }

    public enum JwtTokenType {
        ACCESS, REFRESH
    }
}
