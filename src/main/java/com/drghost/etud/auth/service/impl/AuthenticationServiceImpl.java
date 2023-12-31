package com.drghost.etud.auth.service.impl;

import com.drghost.etud.auth.dao.request.SignInRequest;
import com.drghost.etud.auth.dao.request.SignUpRequest;
import com.drghost.etud.auth.dao.response.JwtAuthenticationResponse;
import com.drghost.etud.auth.entities.Role;
import com.drghost.etud.auth.entities.User;
import com.drghost.etud.auth.repository.UserRepository;
import com.drghost.etud.auth.service.AuthenticationService;
import com.drghost.etud.auth.service.JwtService;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.STUDENT).build();
        Optional<User> userWithPassedEmail = userRepository.findByEmail(request.getEmail());

        if(userWithPassedEmail.isPresent()){
           throw new IllegalStateException("User with this email already exists");
        }else{
            userRepository.save(user);
        }
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
