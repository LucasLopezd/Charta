package com.wallet.wallet.api.service;

import com.wallet.wallet.domain.dto.request.AuthenticationRequest;
import com.wallet.wallet.domain.dto.request.UserRequestDto;
import com.wallet.wallet.domain.dto.response.UserResponseDto;
import com.wallet.wallet.domain.model.User;

public interface IUserService {

    UserResponseDto validate(AuthenticationRequest dto);
    UserResponseDto authenticate(AuthenticationRequest dto);
    UserResponseDto save(UserRequestDto dto);
    User getByEmail(String email);
    User getById(Long id);
}
