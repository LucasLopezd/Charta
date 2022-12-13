package com.wallet.wallet.domain.dto.response;

import lombok.Data;

@Data
public class UserResponseDto {

    private String firstName;

    private String lastName;

    private String email;

    private String jwt;

}
