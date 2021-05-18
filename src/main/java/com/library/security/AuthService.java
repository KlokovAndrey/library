package com.library.security;

import com.library.controller.exception.PersonAlreadyExistsException;
import com.library.controller.exception.PersonNotFoundException;
import com.library.domain.dto.SignUpDto;
import com.library.domain.dto.TokenRequest;
import com.library.domain.entity.Address;
import com.library.domain.entity.Person;
import com.library.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService tokenService;
    private final ConversionService conversionService;

    public String generateToken(TokenRequest tokenRequest) {
        Person person = personRepository.findByEmail(tokenRequest.getUsername()).orElseThrow(() -> new PersonNotFoundException());
        if (!passwordEncoder.matches(tokenRequest.getPassword(), person.getPassword())) {
            throw new RuntimeException();
        }
        return tokenService.generateToken(person);
    }

    public String signUp(SignUpDto signUpDto) {
        Optional<Person> isExists = personRepository.findByEmail(signUpDto.getEmail());
        if(!isExists.isEmpty()) throw new PersonAlreadyExistsException();
        Person person = new Person();
        person.setEmail(signUpDto.getEmail());
        person.setRole("ROLE_USER");
        person.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        person.setName(signUpDto.getName());
        person.setAddress(conversionService.convert(signUpDto.getAddress(), Address.class));
        personRepository.save(person);
        return generateToken(
                TokenRequest.builder()
                        .username(signUpDto.getEmail())
                        .password(signUpDto.getPassword())
                        .build()
        );
    }
}
