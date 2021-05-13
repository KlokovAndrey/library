package com.library.converter.address;

import com.library.domain.dto.AddressDto;
import com.library.domain.entity.Address;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class AddressAddressDtoConverter implements Converter<Address, AddressDto> {
    @Override
    public AddressDto convert(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouse(address.getHouse());
        addressDto.setFlat(address.getFlat());
        return addressDto;
    }
}
