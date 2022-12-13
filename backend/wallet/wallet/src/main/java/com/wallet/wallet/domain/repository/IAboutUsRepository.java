package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAboutUsRepository extends JpaRepository<AboutUs, Long> {
}
