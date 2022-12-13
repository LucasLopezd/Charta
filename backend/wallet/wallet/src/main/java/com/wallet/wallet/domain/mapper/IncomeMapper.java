package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.ExpenseRequestDto;
import com.wallet.wallet.domain.dto.request.ExpenseUpdateDto;
import com.wallet.wallet.domain.dto.request.IncomeRequestDto;
import com.wallet.wallet.domain.dto.request.IncomeUpdateDto;
import com.wallet.wallet.domain.dto.response.ExpenseResponseDto;
import com.wallet.wallet.domain.dto.response.IncomeResponseDto;
import com.wallet.wallet.domain.dto.response.MoveResponseDto;
import com.wallet.wallet.domain.model.Expense;
import com.wallet.wallet.domain.model.Income;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class IncomeMapper implements IMapper<Income, IncomeResponseDto, IncomeRequestDto>{

    @Mapping(source = "amount", target = "importe")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "type", target = "categoria")
    @Mapping(source = "currency.codeCurrency", target = "monedaCodigo")
    @Mapping(source = "date", target = "fecha")
    @Mapping(source = "isIncluded", target = "esIncluida")
    public abstract IncomeResponseDto entityToResponseDto(Income income);

    @Mapping(source = "importe", target = "amount")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "monedaId", target = "currency.id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "fecha", target = "date")
    @Mapping(source = "esIncluida", target = "isIncluded")
    @Mapping(source = "tipo", target = "type")
    public abstract Income requestDtoToEntity(IncomeRequestDto incomeRequestDto);

    @Mapping(source = "importe", target = "amount")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "tipo", target = "type")
    @Mapping(source = "fecha", target = "date")
    @Mapping(source = "esIncluida", target = "isIncluded")
    public abstract Income updateToEntity(IncomeUpdateDto incomeUpdateDto);

    @Mapping(source = "amount", target = "importe")
    @Mapping(source = "type", target = "categoria")
    //@Mapping(source = "category.icon", target = "categoriaIcono")
    //@Mapping(source = "category.colorCode", target = "categoriaColor")
    @Mapping(source = "currency.codeCurrency", target = "monedaCodigo")
    @Mapping(source = "date", target = "fecha")
    @Mapping(constant = "ingreso", target = "tipo")
    public abstract MoveResponseDto entityToMoveResponseDto(Income income);

}
