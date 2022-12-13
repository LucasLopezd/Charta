package com.wallet.wallet.domain.dto.response;

import com.wallet.wallet.domain.model.Expense;
import lombok.Data;

import java.util.List;

@Data
public class CategoryGroupResponseDto {

    private List<Expense> expenses;
}
