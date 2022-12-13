package com.wallet.wallet.domain.dto.request;

import lombok.Data;

@Data
public class AboutUsRequestDto {

    private Long id;

    private String nameComplete;

    private String role;

    private String description;

    private String image;

    private String linkedIn;

    private String behance;

    private String github;

    private String email;

}
