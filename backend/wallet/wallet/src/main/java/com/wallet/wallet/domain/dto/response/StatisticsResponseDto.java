package com.wallet.wallet.domain.dto.response;

import lombok.Data;

import java.time.Month;
import java.util.List;

@Data
public class StatisticsResponseDto {

    List<Double> incomes;
    List<Double> expenses;
    List<Month> months;
}
