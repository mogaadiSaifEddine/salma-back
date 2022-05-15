package com.ark.fileuploaddb.controller;


import com.ark.fileuploaddb.Request.LoginRequest;
import com.ark.fileuploaddb.Request.SignupRequest;
import com.ark.fileuploaddb.model.User;
import com.ark.fileuploaddb.repository.UserRepository;
import com.ark.fileuploaddb.response.JwtResponse;
import com.ark.fileuploaddb.response.MessageResponse;
import com.ark.fileuploaddb.security.jwt.JwtUtils;
import com.ark.fileuploaddb.service.user.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;




    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        boolean matchResult;
        User user;
        user = userRepository.findByEmail(loginRequest.getUsername()).orElse(null);
//        System.out.println(user);
        if (user == null) {
            return ResponseEntity.ok(new MessageResponse("notuser"));
        }

        matchResult = encoder.matches(loginRequest.getPassword(), user.getPassword());
        if ( matchResult == false){
            return ResponseEntity.ok(new MessageResponse("password"));
        }
        else{
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//             System.out.println(authentication);

//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            String jwt = jwtUtils.generateJwtToken(authentication);
//            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//            System.out.println(userDetails);


            return ResponseEntity.ok(user);

        }
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
        System.out.println(signUpRequest);
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getName(),

                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
//                signUpRequest.getCreationDateTime(),
                signUpRequest.getRole());
//        Set<String> strRoles = signUpRequest.getRole();



        userRepository.save(user);


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
