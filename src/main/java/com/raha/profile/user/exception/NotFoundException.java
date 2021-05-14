package com.raha.profile.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "The user not found.")
public class NotFoundException extends RuntimeException {
}
