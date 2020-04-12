package com.sideprojects.trivialpursuit.model.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class UnauthorizedException extends Exception {

    private static final long serialVersionUID = 1L;

}
