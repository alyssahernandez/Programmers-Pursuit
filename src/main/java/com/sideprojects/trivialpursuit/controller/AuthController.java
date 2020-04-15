package com.sideprojects.trivialpursuit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.Tokens;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import com.sideprojects.trivialpursuit.model.auth.AppConfig;

@Component
public class AuthController {
    
	private final AuthenticationController controller;

    @Autowired
    public AuthController(AppConfig config) {
        JwkProvider jwkProvider = new JwkProviderBuilder(config.getDomain()).build();
        controller = AuthenticationController.newBuilder(config.getDomain(), config.getClientId(), config.getClientSecret())
                .withJwkProvider(jwkProvider)
                .build();
    }

    public Tokens handle(HttpServletRequest request, HttpServletResponse response) throws IdentityVerificationException {
        return controller.handle(request, response);
    }

    public String buildAuthorizeUrl(HttpServletRequest request, HttpServletResponse response, String redirectUri) {
        return controller.buildAuthorizeUrl(request, response, redirectUri)
                .build();
    }
}