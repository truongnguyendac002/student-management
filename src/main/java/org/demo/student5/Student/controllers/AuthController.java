//package org.demo.student5.Student.controllers;
//
//import jakarta.validation.Valid;
//import org.demo.student5.Student.repository.RoleRepository;
//import org.demo.student5.Student.repository.UserRepository;
//import org.demo.student5.Student.security.jwt.JwtUnits;
//import org.demo.student5.payload.request.LoginRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("api/auth")
//public class AuthController {
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Autowired
//    JwtUnits jwtUnits;
//
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
//
//    }
//}
