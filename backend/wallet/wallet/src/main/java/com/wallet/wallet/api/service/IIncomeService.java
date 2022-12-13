package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.IncomeRequestDto;
import com.wallet.wallet.domain.dto.request.IncomeUpdateDto;
import com.wallet.wallet.domain.dto.response.IncomeResponseDto;
import com.wallet.wallet.domain.enums.EIncome;
import com.wallet.wallet.domain.model.Income;

import java.time.LocalDate;
import java.util.List;

public interface IIncomeService extends GenericServiceAPI<Income, IncomeResponseDto, IncomeRequestDto, Long> {

    IncomeResponseDto save(IncomeRequestDto incomeRequestDto, String token);

    IncomeResponseDto update(IncomeUpdateDto incomeUpdateDto, Long id, String token);

    IncomeResponseDto findById(Long Id);

    List<IncomeResponseDto> findAll();

    List<IncomeResponseDto> filter(String token, EIncome type, Double amountMax, Double amountMin, LocalDate start, LocalDate end, String orderBy, String order);

    List<IncomeResponseDto> getAllByUserId(String token);

    Double getBalanceMonthlyByUserId(List<Income> incomes);

    Double getBalanceYearlyByUserId(Long userId, Integer year);

    List<Income> convertIncome(List<Income> incomes, String userCodeCurrency, Double userValueDollar);

    void delete(Long id, String token);
}
