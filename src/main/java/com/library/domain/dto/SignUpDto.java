package com.library.domain.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class SignUpDto {
    private String email;
    private String password;
    private String name;
    private AddressDto address;
}
