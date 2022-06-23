package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserSignUpDto;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User register(UserSignUpDto userSignUpDto) {
        Optional<User> findByEmail = userRepository.findByEmail(userSignUpDto.getEmail());
        log.info("sdfsf");
        if(findByEmail.isPresent()) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }

//        userSignUpDto.setPassword(passwordEncoder.encode(userSignUpDto.getPassword()));

        User user = userSignUpDto.toEntity();

        return userRepository.save(user);
    }

    @Transactional
    public void login(UserLoginDto userLoginDto) {

        User user = userRepository.findByEmail(userLoginDto.getEmail())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 user입니다."));

        if(userLoginDto.getPassword() == user.getPassword()) {
            throw new IllegalStateException("비밀번호가 틀렸습니다.");
        }
    }
}
