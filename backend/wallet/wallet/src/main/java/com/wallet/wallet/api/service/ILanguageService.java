package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.LanguageRequestDto;
import com.wallet.wallet.domain.dto.response.LanguageResponseDto;
import com.wallet.wallet.domain.model.Language;

public interface ILanguageService extends GenericServiceAPI<Language, LanguageResponseDto, LanguageRequestDto, Long> {
}
