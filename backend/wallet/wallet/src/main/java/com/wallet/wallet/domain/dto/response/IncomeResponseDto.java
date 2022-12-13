package com.wallet.wallet.domain.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeResponseDto {

    private Long id;

    private Double importe;

    private String descripcion;

    private String categoria;

    private String monedaCodigo;

    private LocalDate fecha;

    private Boolean esIncluida;

    private Boolean deleted;

}
