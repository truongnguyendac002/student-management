package org.demo.student5.Student.service;

import org.demo.student5.Student.payload.LoginDto;
import org.demo.student5.Student.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto) ;
}
