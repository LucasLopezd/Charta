package com.wallet.wallet.consume.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.wallet.consume.connection.ApiFixer;
import com.wallet.wallet.consume.dto.CurrencyDto;
import com.wallet.wallet.consume.service.IConsumer;

@Service
public record ConsumerServiceImpl(ApiFixer api, ObjectMapper mapper) implements IConsumer {

    public List<CurrencyDto> getCurrencies() {
        List<CurrencyDto> currencies = new ArrayList<>();

        try {
            Object object = new JSONObject(api.getConnection(ENDPOINT_CURRENCIES)).getJSONObject("rates");
            Map<String, Double> map = mapper.readValue(object.toString(), new TypeReference<Map<String, Double>>() {
            });

            List<String> codes = getListOfKeys(map);
            List<Double> values = getListOfValues(map);

            for (int i = 0; i < codes.size(); i++) {
                currencies.add(CurrencyDto.builder()
                        .codeCurrency(codes.get(i))
                        .valueDollar(values.get(i))
                        .build());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return currencies;
    }
}
