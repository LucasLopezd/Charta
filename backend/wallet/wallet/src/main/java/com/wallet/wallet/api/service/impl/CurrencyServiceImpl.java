package com.wallet.wallet.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wallet.wallet.domain.mapper.IMapperCurrency;
import com.wallet.wallet.domain.model.Currency;
import com.wallet.wallet.domain.repository.ICurrencyRepository;

import lombok.RequiredArgsConstructor;

import com.wallet.wallet.api.service.ICurrencyService;
import com.wallet.wallet.consume.dto.CurrencyDto;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements ICurrencyService{

    private final ICurrencyRepository repository;
    private final IMapperCurrency mapper;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void updateAll(List<CurrencyDto> currencies) {        
        if(repository.count() == 0){
            List<Currency> newCurrencies = mapper.toCurrencyList(currencies);
            repository.saveAll(newCurrencies);
        }else{
            List<Currency> updateCurrencies = repository.findAll();
            for (int i = 0; i < currencies.size(); i++) {
                updateCurrencies.get(i).setValueDollar(currencies.get(i).getValueDollar());
                repository.saveAll(updateCurrencies);
            } 
        }
    }

    @Override
    public List<Currency> saveAll(List<CurrencyDto> currencies) {
        return repository.saveAll(mapper.toCurrencyList(currencies));
    }
    

}
