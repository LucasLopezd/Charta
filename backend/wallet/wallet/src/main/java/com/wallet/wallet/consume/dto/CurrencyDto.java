package com.wallet.wallet.consume.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CurrencyDto {
    
    private String codeCurrency;
    private Double valueDollar; 
}
