package com.wallet.wallet.domain.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseResponseDto {

    private Long id;

    private Double importe;

    private String descripcion;

    private String categoria;

    private String categoriaIcono;

    private String categoriaColor;

    private String monedaCodigo;

    private LocalDate fecha;

    private Boolean esIncluida;

    private Boolean deleted = Boolean.FALSE;

}
