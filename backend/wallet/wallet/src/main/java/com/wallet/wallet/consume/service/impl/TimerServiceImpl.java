package com.wallet.wallet.consume.service.impl;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.wallet.wallet.api.service.ICurrencyService;
import com.wallet.wallet.consume.service.IConsumer;
import com.wallet.wallet.consume.service.ITimer;

@Service
@EnableScheduling
public record TimerServiceImpl(IConsumer consumerService, ICurrencyService currencyService) implements ITimer{
    
    @Scheduled(cron = "0 0 6,18 * * *")
    public void refreshCurrency() {
        currencyService.updateAll(consumerService.getCurrencies());
    }
}
