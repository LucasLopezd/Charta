package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.api.service.IAboutUsService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.AboutUsRequestDto;
import com.wallet.wallet.domain.dto.response.AboutUsResponseDto;
import com.wallet.wallet.domain.mapper.AboutUsMapper;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.model.AboutUs;
import com.wallet.wallet.domain.repository.IAboutUsRepository;

import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AboutUsServiceImpl extends GenericServiceImpl<AboutUs, AboutUsResponseDto, AboutUsRequestDto, Long>
        implements IAboutUsService {

    private final IAboutUsRepository repository;
    private final AboutUsMapper aboutUsMapper;

    public AboutUsResponseDto save(AboutUsRequestDto dto) {
        return super.save(dto);
    }

    @Override
    public List<AboutUsResponseDto> findAll() {
        List<AboutUsResponseDto> response = repository.findAll()
                .stream()
                .map(s -> aboutUsMapper.entityToResponseDto(s))
                .collect(Collectors.toList());
        Collections.shuffle(response);

        return response;
    }

    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public JpaRepository<AboutUs, Long> getRepository() {
        return repository;
    }

    @Override
    public IMapper<AboutUs, AboutUsResponseDto, AboutUsRequestDto> getMapper() {
        return aboutUsMapper;
    }

    @Override
    public MessageSource getMessenger() {
        return null;
    }

}
