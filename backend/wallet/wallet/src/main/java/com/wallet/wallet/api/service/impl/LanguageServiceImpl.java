package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.api.service.ILanguageService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.LanguageRequestDto;
import com.wallet.wallet.domain.dto.response.LanguageResponseDto;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.mapper.LanguageMapper;
import com.wallet.wallet.domain.model.Language;
import com.wallet.wallet.domain.repository.ILanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LanguageServiceImpl extends GenericServiceImpl<Language, LanguageResponseDto, LanguageRequestDto, Long> implements ILanguageService {

    private ILanguageRepository languageRepository;
    private LanguageMapper languageMapper;
    private final MessageSource messenger;

    @Override
    public JpaRepository<Language, Long> getRepository() {
        return languageRepository;
    }

    @Override
    public IMapper<Language, LanguageResponseDto, LanguageRequestDto> getMapper() {
        return languageMapper;
    }

    @Override
    public MessageSource getMessenger() {
        return messenger;
    }
}
