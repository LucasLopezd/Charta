package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.Security.jwt.JwtUtil;
import com.wallet.wallet.api.service.IIncomeService;
import com.wallet.wallet.api.service.IUserService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.IncomeRequestDto;
import com.wallet.wallet.domain.dto.request.IncomeUpdateDto;
import com.wallet.wallet.domain.dto.response.IncomeResponseDto;
import com.wallet.wallet.domain.enums.EIncome;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.mapper.IncomeMapper;
import com.wallet.wallet.domain.model.Income;
import com.wallet.wallet.domain.model.User;
import com.wallet.wallet.domain.repository.IIncomeRepository;

import com.wallet.wallet.handler.exception.UserUnauthorizedException;
import lombok.AllArgsConstructor;

import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.wallet.wallet.domain.enums.EMessageCode.USER_UNAUTHORIZED;

@Service
@AllArgsConstructor
public class IncomeServiceImpl extends GenericServiceImpl<Income, IncomeResponseDto, IncomeRequestDto, Long> implements IIncomeService {

    private final IIncomeRepository repository;
    private final IncomeMapper mapper;
    private final IUserService userService;
    private final JwtUtil jwtUtil;
    private final MessageSource messenger;

    @Override
    public IncomeResponseDto save(IncomeRequestDto incomeRequestDto, String token) {
        Long userId = jwtUtil.extractUserId(token);
        incomeRequestDto.setUserId(userId);
        return super.save(incomeRequestDto);
    }

    @Override
    public IncomeResponseDto update(IncomeUpdateDto incomeUpdateDto, Long id, String token) {

        Long userId = jwtUtil.extractUserId(token);
        Optional<Income> income = repository.findById(id);

        if (userId.equals(income.get().getUser().getId())) {
            incomeUpdateDto.setId(id);
            Income incomeSave = mapper.updateToEntity(incomeUpdateDto);
            incomeSave.setCurrency(income.get().getCurrency());
            incomeSave.setUser(income.get().getUser());
            repository.save(incomeSave);
        } else {
            throw new UserUnauthorizedException(messenger.getMessage(USER_UNAUTHORIZED.name(),
                    new Object[] {userId, income.get().getUser().getId()}, Locale.getDefault()));
        }
        return getById(id);
    }

    @Override
    public IncomeResponseDto findById(Long Id){

        return mapper.entityToResponseDto(repository.findById(Id).get());
    }

    @Override
    public List<IncomeResponseDto> findAll(){

        return repository.findAll()
                .stream()
                .map(mapper::entityToResponseDto)
                .toList();
    }

    @Override
    public List<IncomeResponseDto> getAllByUserId(String token) {
        Long userId = jwtUtil.extractUserId(token);
        User user = userService.getById(userId);

        return convertIncome(repository.getAllByUserId(userId), user.getCurrency().getCodeCurrency(), user.getCurrency().getValueDollar())
                .stream()
                .map(mapper::entityToResponseDto)
                .toList();
    }

    public Double getBalanceMonthlyByUserId(List<Income> incomes) {

        Double balance = 0.0;

        for (Income income : incomes){
            balance += income.getAmount();
        }

        return balance;
    }

    public Double getBalanceYearlyByUserId(Long userId, Integer year) {

        Double balance = 0.0;

        User user = userService.getById(userId);
        String userCodeCurrency = user.getCurrency().getCodeCurrency();
        Double userValueCurrency = user.getCurrency().getValueDollar();

        List<Income> incomesYearly = convertIncome(repository.getYearlyByUserId(userId, year),userCodeCurrency, userValueCurrency);
        for (Income income : incomesYearly){
            balance += (income.getAmount()/12);
        }

        return balance;
    }


    @Override
    public List<IncomeResponseDto> filter(String token, EIncome type, Double amountMin, Double amountMax, LocalDate start, LocalDate end, String orderBy, String order) {

        Long userId = jwtUtil.extractUserId(token);
        User user = userService.getById(userId);
        String userCodeCurrency = user.getCurrency().getCodeCurrency();
        Double userValueCurrency = user.getCurrency().getValueDollar();

        List<Income> incomes;

        if(type != null && start != null && end != null ){
            incomes = convertIncome(repository.filterByCategoriesAndDate(userId, type, start, end, Sort.by(order.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy)), userCodeCurrency, userValueCurrency);
        } else if(type != null){
            incomes = convertIncome(repository.filterByCategories(userId, type, Sort.by(order.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy)), userCodeCurrency, userValueCurrency);
        } else if(start != null && end != null) {
            incomes = convertIncome(repository.filterByDate(userId, start, end, Sort.by(order.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy)), userCodeCurrency, userValueCurrency);
        }else{
            incomes = convertIncome(repository.getAllByUserId(userId, Sort.by(order.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy)), userCodeCurrency, userValueCurrency);
        }

        if(amountMin != null && amountMax != null){
            for(int i = 0; i < incomes.size(); i++){
                if(incomes.get(i).getAmount() < amountMin || incomes.get(i).getAmount() > amountMax){
                    incomes.remove(incomes.get(i));
                    i--;
                }
            }
        }
        return incomes.stream().map(mapper::entityToResponseDto).toList();
    }


    public Double formatDecimals(Double number, Integer decimals) {
        return Math.round(number * Math.pow(10, decimals)) / Math.pow(10, decimals);
    }

    public List<Income> convertIncome(List<Income> incomes, String userCodeCurrency, Double userValueDollar){
        for(Income income : incomes){
            if(!income.getCurrency().getCodeCurrency().equals(userCodeCurrency)){
                if(income.getCurrency().getCodeCurrency().equals("USD")){
                    income.setAmount(formatDecimals(income.getAmount()*income.getCurrency().getValueDollar(),2));
                } else {
                    income.setAmount(formatDecimals((income.getAmount()/income.getCurrency().getValueDollar()) * userValueDollar,2));
                }
            }
        }

        return incomes;
    }

    @Override
    public void delete(Long id, String token){

        Long userId = jwtUtil.extractUserId(token);

        Optional<Income> income = repository.findById(id);

        if (userId.equals(income.get().getUser().getId())) {
            super.delete(id);
        } else {
            throw new UserUnauthorizedException(messenger.getMessage(USER_UNAUTHORIZED.name(),
                    new Object[]{userId, income.get().getUser().getId()}, Locale.getDefault()));
        }
    }

    @Override
    public JpaRepository<Income, Long> getRepository() {
        return repository;
    }

    @Override
    public IMapper<Income, IncomeResponseDto, IncomeRequestDto> getMapper() {
        return mapper;
    }

    @Override
    public MessageSource getMessenger() {
        return null;
    }
}
