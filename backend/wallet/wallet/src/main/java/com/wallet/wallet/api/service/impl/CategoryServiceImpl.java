package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.Security.jwt.JwtUtil;
import com.wallet.wallet.api.service.ICategoryService;
import com.wallet.wallet.api.service.IUserService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.CategoryRequestDto;
import com.wallet.wallet.domain.dto.request.CategoryUpdateDto;
import com.wallet.wallet.domain.dto.response.CategoryResponseDto;
import static com.wallet.wallet.domain.enums.EMessageCode.*;

import com.wallet.wallet.domain.enums.ERole;
import com.wallet.wallet.domain.mapper.CategoryMapper;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.model.Category;
import com.wallet.wallet.domain.model.User;
import com.wallet.wallet.domain.repository.ICategoryRepository;
import com.wallet.wallet.handler.exception.UserUnauthorizedException;

import lombok.AllArgsConstructor;

import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, CategoryResponseDto, CategoryRequestDto, Long>
        implements ICategoryService {

    private final CategoryMapper categoryMapper;
    private final ICategoryRepository repository;
    private final IUserService userService;;
    private final JwtUtil jwtUtil;
    private final MessageSource messenger;

    @Override
    public CategoryResponseDto save(CategoryRequestDto categoryRequestDto, String token) {
        Long id = jwtUtil.extractUserId(token);
        User user = userService.getById(id);
        categoryRequestDto.setUserIdCreate(id);
        categoryRequestDto.setIsDefault(user.getRole().equals(ERole.ADMIN) ? true : false);

        return super.save(categoryRequestDto);
    }

    @Override
    public CategoryResponseDto update(CategoryUpdateDto dto, Long id, String token) {

        Long userId = jwtUtil.extractUserId(token);
        User user = userService.getById(userId);

        Optional<Category> category = repository.findById(id);

        if (user.getRole().equals(ERole.ADMIN) || userId.equals(category.get().getUserIdCreate())) {
            dto.setId(id);
            repository.save(categoryMapper.updateToEntity(dto));
        } else {
            throw new UserUnauthorizedException(messenger.getMessage(USER_UNAUTHORIZED.name(),
                    new Object[] {userId, category.get().getUserIdCreate()}, Locale.getDefault()));
        }
        return getById(id);
    }

    @Override
    public CategoryResponseDto getById(Long id, String token) {

        Long userId = jwtUtil.extractUserId(token);

        Optional<Category> category = repository.findById(id);

        if (userId.equals(category.get().getUserIdCreate())) {
            return super.getById(id);
        } else {
            throw new UserUnauthorizedException(messenger.getMessage(USER_UNAUTHORIZED.name(),
                    new Object[] {userId, category.get().getUserIdCreate()}, Locale.getDefault()));
        }
    }

    @Override
    public List<CategoryResponseDto> getAll() {
        return categoryMapper.listEntityToListResponseDto(repository.findAll());
    }

    @Override
    public List<CategoryResponseDto> getAllByUserId(String token) {
        Long userId = jwtUtil.extractUserId(token);
        return categoryMapper.listEntityToListResponseDto(repository.getAllByUserId(userId));
    }

    public void delete(Long id, String token) {

        Long userId = jwtUtil.extractUserId(token);

        Optional<Category> category = repository.findById(id);

        if (userId.equals(category.get().getUserIdCreate())) {
            super.delete(id);
        } else {
            throw new UserUnauthorizedException(messenger.getMessage(USER_UNAUTHORIZED.name(),
                    new Object[]{userId, category.get().getUserIdCreate()}, Locale.getDefault()));
        }
    }

    @Override
    public JpaRepository<Category, Long> getRepository() {
        return repository;
    }

    @Override
    public IMapper<Category, CategoryResponseDto, CategoryRequestDto> getMapper() {
        return categoryMapper;
    }

    @Override
    public MessageSource getMessenger() {
        return messenger;
    }
}
