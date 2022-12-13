package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.ExpenseRequestDto;
import com.wallet.wallet.domain.dto.request.ExpenseUpdateDto;
import com.wallet.wallet.domain.dto.response.ExpenseResponseDto;
import com.wallet.wallet.domain.dto.response.MoveResponseDto;
import com.wallet.wallet.domain.model.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ExpenseMapper implements IMapper<Expense, ExpenseResponseDto, ExpenseRequestDto> {

    @Mapping(source = "amount", target = "importe")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "date", target = "fecha")
    @Mapping(source = "category.name", target = "categoria")
    @Mapping(source = "category.icon", target = "categoriaIcono")
    @Mapping(source = "category.colorCode", target = "categoriaColor")
    @Mapping(source = "currency.codeCurrency", target = "monedaCodigo")
    @Mapping(source = "isIncluded", target = "esIncluida")
    public abstract ExpenseResponseDto entityToResponseDto(Expense expense);

    @Mapping(source = "importe", target = "amount")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "categoriaId", target = "category.id")
    @Mapping(source = "monedaId", target = "currency.id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "fecha", target = "date")
    @Mapping(source = "esIncluida", target = "isIncluded")
    public abstract Expense requestDtoToEntity(ExpenseRequestDto expenseRequestDto);

    @Mapping(source = "importe", target = "amount")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "categoriaId", target = "category.id")
    @Mapping(source = "fecha", target = "date")
    @Mapping(source = "esIncluida", target = "isIncluded")
    public abstract Expense updateToEntity(ExpenseUpdateDto expenseUpdateDto);

    public abstract List<ExpenseResponseDto> listEntityToListResponseDto(List<Expense> expenses);

    @Mapping(source = "amount", target = "importe")
    @Mapping(source = "category.name", target = "categoria")
    @Mapping(source = "category.icon", target = "categoriaIcono")
    @Mapping(source = "category.colorCode", target = "categoriaColor")
    @Mapping(source = "currency.codeCurrency", target = "monedaCodigo")
    @Mapping(source = "date", target = "fecha")
    @Mapping(constant = "gasto", target = "tipo")
    @Mapping(source = "isIncluded", target = "esIncluida")
    public abstract MoveResponseDto entityToMoveResponseDto(Expense expense);

}