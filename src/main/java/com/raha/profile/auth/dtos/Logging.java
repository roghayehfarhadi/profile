package com.raha.profile.auth.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Logging {

    private String userName;

    private String password;
}
