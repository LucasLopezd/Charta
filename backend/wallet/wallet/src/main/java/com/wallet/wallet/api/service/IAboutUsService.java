package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.AboutUsRequestDto;
import com.wallet.wallet.domain.dto.response.AboutUsResponseDto;
import com.wallet.wallet.domain.model.AboutUs;

import java.util.List;


public interface IAboutUsService extends GenericServiceAPI<AboutUs, AboutUsResponseDto, AboutUsRequestDto, Long> {

    List<AboutUsResponseDto> findAll();
}
