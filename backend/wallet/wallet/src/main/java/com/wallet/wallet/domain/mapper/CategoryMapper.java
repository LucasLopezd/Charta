package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.CategoryRequestDto;
import com.wallet.wallet.domain.dto.request.CategoryUpdateDto;
import com.wallet.wallet.domain.dto.response.CategoryResponseDto;
import com.wallet.wallet.domain.dto.response.ExpenseResponseDto;
import com.wallet.wallet.domain.model.Category;
import com.wallet.wallet.domain.model.Expense;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper implements IMapper<Category, CategoryResponseDto, CategoryRequestDto> {

    public abstract CategoryRequestDto updateToRequestDto(CategoryUpdateDto categoryUpdateDto);

    public abstract Category updateToEntity(CategoryUpdateDto categoryUpdateDto);

    public abstract List<CategoryResponseDto> listEntityToListResponseDto(List<Category> categories);

}
