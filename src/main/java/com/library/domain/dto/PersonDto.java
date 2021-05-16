package com.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private UUID id;
    private String name;
    private String email;
    private AddressDto address;
    private List<TakenBookDto> books;

}
