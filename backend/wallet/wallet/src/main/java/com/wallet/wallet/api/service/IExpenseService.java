package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.ExpenseRequestDto;
import com.wallet.wallet.domain.dto.request.ExpenseUpdateDto;
import com.wallet.wallet.domain.dto.response.ExpenseResponseDto;
import com.wallet.wallet.domain.dto.response.HomeResponseDto;
import com.wallet.wallet.domain.dto.response.StatisticsResponseDto;
import com.wallet.wallet.domain.model.Expense;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IExpenseService extends GenericServiceAPI<Expense, ExpenseResponseDto, ExpenseRequestDto, Long> {

    ExpenseResponseDto save(ExpenseRequestDto expenseRequestDto,String token);

    ExpenseResponseDto update(ExpenseUpdateDto expenseUpdateDto, Long id, String token);

    ExpenseResponseDto getById(Long id, String token);

    List<ExpenseResponseDto> getAllByUserId(String token);

    Map<String, Double> groupByCategoryByUserId(String token);

    HomeResponseDto getForHome(String token);

    List<ExpenseResponseDto> filter(String token, List<Long> categoriesId, Double amountMax, Double amountMin, LocalDate start, LocalDate end, String orderBy, String order);

    StatisticsResponseDto getStatistics(String token);

    void delete(Long id, String token);

}
