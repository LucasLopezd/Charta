package com.wallet.wallet.domain.mapper;


import com.wallet.wallet.domain.dto.request.AboutUsRequestDto;
import com.wallet.wallet.domain.dto.response.AboutUsResponseDto;
import com.wallet.wallet.domain.model.AboutUs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AboutUsMapper implements IMapper<AboutUs, AboutUsResponseDto, AboutUsRequestDto> {
}
