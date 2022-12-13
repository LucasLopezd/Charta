package com.wallet.wallet.domain.dto.request;

import lombok.Data;

@Data
public class LanguageRequestDto {

    private Long id;

    private String name;

    private String flag;

    private Boolean deleted = Boolean.FALSE;

}
