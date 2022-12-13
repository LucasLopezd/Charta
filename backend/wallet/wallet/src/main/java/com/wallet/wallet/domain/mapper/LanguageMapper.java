package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.LanguageRequestDto;
import com.wallet.wallet.domain.dto.response.LanguageResponseDto;
import com.wallet.wallet.domain.model.Language;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class LanguageMapper implements IMapper<Language, LanguageResponseDto, LanguageRequestDto> {
}
