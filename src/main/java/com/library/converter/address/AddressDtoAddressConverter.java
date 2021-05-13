package com.library.converter.address;

import com.library.domain.dto.AddressDto;
import com.library.domain.entity.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoAddressConverter implements Converter<AddressDto, Address>{
    @Override
    public Address convert(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouse(addressDto.getHouse());
        address.setFlat(addressDto.getFlat());
        return address;
    }
}
