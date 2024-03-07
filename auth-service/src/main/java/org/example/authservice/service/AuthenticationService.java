package org.example.authservice.service;


import org.example.authservice.model.AuthenticationResponse;
import org.example.authservice.model.User;
import org.example.authservice.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(User request){
//        User user = new User();
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setUsername(request.getUsername());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//
//        user.setRole(request.getRole());
//
//        user = userRepository.save(user);
//
//        String token = jwtService.generateToken(user);
//
//        User createdUser = new User();
//        createdUser.setUsername(request.getUsername());
//        createdUser.setPassword(passwordEncoder.encode(request.getPassword()));
//        createdUser.setEmail(request.getEmail());
//        createdUser.setImageUrl(request.getImageUrl());
//        createdUser.setRole(request.getRole());
//        createdUser = userRepository.save(createdUser);

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User createdUser = userRepository.save(request);

        String token = jwtService.generateToken(request);
        return new AuthenticationResponse(token, createdUser.getId(), createdUser.getUsername(), createdUser.getImageUrl());


//        return new AuthenticationResponse(token);

    }

    public AuthenticationResponse authenticate(User request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token, user.getId(), user.getUsername(), user.getImageUrl());
    }

}
