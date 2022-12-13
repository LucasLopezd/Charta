package com.wallet.wallet.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ExpenseRequestDto {

    @Schema(type = "double", example = "100.5")
    private Double importe;

    @Schema(type = "string", example = "")
    private String descripcion;

    @Schema(type = "long", example = "1")
    private Long categoriaId;

    @Schema(type = "long", example = "1")
    private Long monedaId;

    @Schema(type = "long", example = "1")
    private Long userId;

    @Schema(type = "localdate", example = "2022-11-30")
    private LocalDate fecha;

    @Schema(type = "boolean", example = "true")
    private Boolean esIncluida;

    @Schema(type = "boolean", example = "false")
    private Boolean deleted = Boolean.FALSE;
}
