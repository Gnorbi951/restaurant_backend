package com.norbi.gocze.restaurant.controller;

import com.norbi.gocze.restaurant.model.UserCredentials;
import com.norbi.gocze.restaurant.security.JwtUtil;
import com.norbi.gocze.restaurant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    // I have refactored this part to only send a token and react library processces the token
    // to a cookie, because heroku and netlify don't like to communicate that way
    @PostMapping("/login")
    public ResponseEntity<List<String>> login(@RequestBody UserCredentials secuUser, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                secuUser.getUsername(),
                secuUser.getPassword()
        ));
        String jwtToken = jwtUtil.generateToken(authentication);
        return ResponseEntity.ok().body(Arrays.asList(secuUser.getUsername(), jwtToken));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserCredentials secuUser) {
        userService.register(secuUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(secuUser.getUsername());
    }

}
