package com.raha.profile.auth.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Getter
@JsonAutoDetect(fieldVisibility = ANY)
public class LoginDto {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    public Logging toLogging() {
        return Logging.builder()
                .userName(userName)
                .password(password)
                .build();
    }
}
