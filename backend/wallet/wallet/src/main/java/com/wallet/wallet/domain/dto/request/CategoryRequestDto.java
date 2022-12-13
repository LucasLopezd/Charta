package com.wallet.wallet.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategoryRequestDto {

    @Schema(type = "long", example = "1")
    private Long id;

    @Schema(type = "string", example = "supermercado", maxLength = 25)
    private String name;

    @Schema(type = "string", example = "basket", maxLength = 25)
    private String icon;

    @Schema(type = "string", example = "#B5EC8A", maxLength = 10)
    private String colorCode;

    @Schema(type = "long", example = "1")
    private Long userIdCreate;

    @Schema(type = "boolean", example = "true")
    private Boolean isDefault;

    @Schema(type = "boolean", example = "false")
    private Boolean deleted = Boolean.FALSE;
}
