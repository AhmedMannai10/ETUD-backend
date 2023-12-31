package com.drghost.etud.auth.controller;

import com.drghost.etud.auth.dao.request.SignInRequest;
import com.drghost.etud.auth.dao.request.SignUpRequest;
import com.drghost.etud.auth.dao.response.JwtAuthenticationResponse;
import com.drghost.etud.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    public final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(authenticationService.signup(request));
    }
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request){
       return ResponseEntity.ok(authenticationService.signin(request));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
       return ResponseEntity.ok("Hello There");
    }
}
