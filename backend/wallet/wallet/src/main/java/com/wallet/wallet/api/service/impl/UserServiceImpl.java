package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.Security.jwt.JwtUtil;
import com.wallet.wallet.api.service.IEmailService;
import com.wallet.wallet.api.service.IUserService;
import com.wallet.wallet.domain.dto.request.AuthenticationRequest;
import com.wallet.wallet.domain.dto.request.UserRequestDto;
import com.wallet.wallet.domain.dto.response.UserResponseDto;
import static com.wallet.wallet.domain.enums.EMessageCode.*;
import com.wallet.wallet.domain.enums.ERole;
import com.wallet.wallet.domain.mapper.UserMapper;
import com.wallet.wallet.domain.model.User;
import com.wallet.wallet.domain.repository.IUserRepository;
import com.wallet.wallet.handler.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

   private final IUserRepository repository;
   private final UserMapper mapper;
   private final PasswordEncoder encoder;
   private final MessageSource messenger;
   private final IEmailService emailService;


   @Override
   public UserResponseDto save(UserRequestDto dto) {
      dto.setPassword(encoder.encode(dto.getPassword()));

      var user = mapper.requestDtoToEntity(dto);
      user.setRole(ERole.PENDING);
      repository.save(user);

      emailService.sendEmail(user.getEmail(), user.getFirstName());

      var response = mapper.entityToResponseDto(user);
      response.setJwt(JwtUtil.generateToken(user));

      return response;
   }

   @Override
   public UserResponseDto validate(AuthenticationRequest dto) {

      var user = getByEmail(dto.getEmail());
      user.setRole(ERole.USER);
      repository.save(user);

      return authenticate(dto);
   }

   @Override
   public UserResponseDto authenticate(AuthenticationRequest dto) {
      var user = getByEmail(dto.getEmail());

      if (encoder.matches(dto.getPassword(), user.getPassword())) {
         var userResponseDto = mapper.entityToResponseDto(user);
         userResponseDto.setJwt(JwtUtil.generateToken(user));
         return userResponseDto;
      }

      return null;
   }

   public User getByEmail(String email) {
      return repository.findByEmail(email).orElseThrow(
         () -> new ResourceNotFoundException(messenger.getMessage(USER_NOT_FOUND_BY_EMAIL.name(),
                 new Object[] { email }, Locale.getDefault())));
         
   }

   
   public User getById(Long id) {
      return repository.findById(id).orElseThrow(
         () -> new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                 new Object[] { User.class.getSimpleName(), id }, Locale.getDefault())));
   }

}

