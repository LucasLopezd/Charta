package com.wallet.wallet.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.wallet.wallet.consume.dto.CurrencyDto;
import com.wallet.wallet.domain.model.Currency;

@Mapper(componentModel = "spring")
public abstract class IMapperCurrency {
    
    @Mapping(target = "valueDollar", source = "valueDollar")
    public abstract List<Currency> toCurrencyList(List<CurrencyDto> dtos);
}
