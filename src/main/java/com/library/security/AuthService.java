package com.library.security;

import com.library.controller.exception.PersonNotFoundException;
import com.library.domain.dto.SignUpDto;
import com.library.domain.dto.TokenRequest;
import com.library.domain.entity.Person;
import com.library.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService tokenService;

    public String generateToken(TokenRequest tokenRequest) {
        Person person = personRepository.findByEmail(tokenRequest.getUsername()).orElseThrow(() -> new PersonNotFoundException());
        if (!passwordEncoder.matches(tokenRequest.getPassword(), person.getPassword())) {
            throw new RuntimeException();
        }
        return tokenService.generateToken(person);
    }

    public String signUp(SignUpDto signUpDto) {
        Person person = new Person();
        person.setEmail(signUpDto.getEmail());
        person.setRole("ROLE_USER");
        person.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        personRepository.save(person);
        return generateToken(
                TokenRequest.builder()
                        .username(signUpDto.getEmail())
                        .password(signUpDto.getPassword())
                        .build()
        );
    }
}
