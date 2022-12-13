package com.wallet.wallet.domain.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MoveResponseDto {

    private Double importe;

    private String categoria;

    private String categoriaIcono;

    private String categoriaColor;

    private String monedaCodigo;

    private LocalDate fecha;

    private String tipo;

    private Boolean esIncluida;

}
