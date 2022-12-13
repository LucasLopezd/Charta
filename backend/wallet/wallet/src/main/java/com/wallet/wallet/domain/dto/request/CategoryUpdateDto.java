package com.wallet.wallet.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategoryUpdateDto {

    @Schema(hidden = true)
    private Long id;

    @Schema(type = "string", example = "mercado", maxLength = 10)
    private String name;

    @Schema(type = "string", example = "market", maxLength = 10)
    private String icon;

    @Schema(type = "string", example = "#B5EC8A", maxLength = 10)
    private String colorCode;

}
