package com.wallet.wallet.domain.dto.response;

import lombok.Data;

@Data
public class CategoryResponseDto {

    private Long id;

    private String name;

    private String icon;

    private String colorCode;

    private Long userIdCreate;

    private Boolean isDefault;

}
