package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;

@Repository
public interface IExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT e FROM Expense e WHERE user.id = ?1 ORDER BY date DESC")
    List<Expense> getAllByUserId(Long userId);

    @Query("SELECT e FROM Expense e WHERE user.id = ?1")
    List<Expense> getAllByUserId(Long userId, Sort sort);

    @Query("SELECT e FROM Expense e WHERE user.id = ?1 AND EXTRACT(MONTH FROM date) = ?2 AND EXTRACT(YEAR FROM date) = ?3 ORDER BY DATE DESC")
    List<Expense> getMonthlyByUserId(Long userId, Integer monthNow, Integer yearNow);

    @Query("SELECT e FROM Expense e WHERE user.id = ?1 AND category.id IN ?2 AND date BETWEEN ?3 AND ?4")
    List<Expense> filterByCategoriesAndDate(Long userId, List<Long> categoriesId, LocalDate start, LocalDate end, Sort sort);

    @Query("SELECT e FROM Expense e WHERE user.id = ?1 AND category.id IN ?2")
    List<Expense> filterByCategories(Long userId, List<Long> categoriesId, Sort sort);

    @Query("SELECT e FROM Expense e WHERE user.id = ?1 AND date BETWEEN ?2 AND ?3")
    List<Expense> filterByDate(Long userId, LocalDate start, LocalDate end, Sort sort);

}
