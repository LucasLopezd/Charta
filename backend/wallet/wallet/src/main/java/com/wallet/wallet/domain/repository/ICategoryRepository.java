package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE isDefault = true OR userIdCreate = ?1")
    List<Category> getAllByUserId(Long userId);

}
