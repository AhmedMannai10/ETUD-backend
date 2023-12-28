package com.drghost.etud.auth.service;

import com.drghost.etud.auth.dao.request.SignInRequest;
import com.drghost.etud.auth.dao.request.SignUpRequest;
import com.drghost.etud.auth.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SignInRequest request);
}

