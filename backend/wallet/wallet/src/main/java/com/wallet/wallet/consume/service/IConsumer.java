package com.wallet.wallet.consume.service;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

import com.wallet.wallet.consume.dto.CurrencyDto;

public interface IConsumer {

    final String ENDPOINT_CURRENCIES = "latest?symbols=&base=USD";

    List<CurrencyDto> getCurrencies();

    default <K, V> List<V> getListOfValues(Map<K, V> map) {
        return map.values().stream().collect(toList());
    }

    default <K, V> List<K> getListOfKeys(Map<K, V> map) {
        return map.keySet().stream().collect(toList());
    }
}
