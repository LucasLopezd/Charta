package com.wallet.wallet.api.controller;

import static org.springframework.http.HttpStatus.ACCEPTED;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.wallet.api.service.ICurrencyService;
import com.wallet.wallet.consume.service.IConsumer;
import static com.wallet.wallet.handler.ResponseBuilder.*;

@RestController
@RequestMapping("/currencies")
public record CurrencyController(ICurrencyService service, IConsumer consumer) {
    
    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAllCurrencies(){
        return responseBuilder(ACCEPTED, service.saveAll(consumer.getCurrencies()));
    }
}
