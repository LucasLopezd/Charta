package com.wallet.wallet.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseUpdateDto {

    @Schema(hidden = true)
    private Long id;

    @Schema(type = "double", example = "100.5")
    private Double importe;

    @Schema(type = "string", example = "")
    private String descripcion;

    @Schema(type = "long", example = "1")
    private Long categoriaId;

    @Schema(type = "localdate", example = "2022-11-30")
    private LocalDate fecha;

    @Schema(type = "boolean", example = "true")
    private Boolean esIncluida;

}
