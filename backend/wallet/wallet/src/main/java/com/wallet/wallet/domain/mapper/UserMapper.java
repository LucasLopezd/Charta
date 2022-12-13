package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.UserRequestDto;
import com.wallet.wallet.domain.dto.response.UserResponseDto;
import com.wallet.wallet.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements IMapper<User, UserResponseDto, UserRequestDto>{

    @Mapping(source = "currencyId", target = "currency.id")
    public abstract User requestDtoToEntity(UserRequestDto userRequestDto);
}
