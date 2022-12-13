package com.wallet.wallet.api.service;

import java.util.List;

import com.wallet.wallet.consume.dto.CurrencyDto;
import com.wallet.wallet.domain.model.Currency;
public interface ICurrencyService {
    
    void updateAll(List<CurrencyDto> currencies);

    List<Currency> saveAll(List<CurrencyDto> currencies);
}
