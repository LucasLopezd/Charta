package com.wallet.wallet.domain.dto.request;

import com.wallet.wallet.domain.enums.EIncome;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeRequestDto {

    private Long id;

    private Double importe;

    private String descripcion;

    private Long monedaId;

    private Long userId;

    private LocalDate fecha;

    private Boolean esIncluida;

    private EIncome tipo;

    private Boolean deleted = Boolean.FALSE;
}
