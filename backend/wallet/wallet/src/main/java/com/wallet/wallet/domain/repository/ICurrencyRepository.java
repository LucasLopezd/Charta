package com.wallet.wallet.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wallet.wallet.domain.model.Currency;

@Repository
public interface ICurrencyRepository extends JpaRepository<Currency, Long>{
    
}
