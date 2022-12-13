package com.wallet.wallet.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wallet.wallet.domain.enums.EIncome;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "incomes")
@Data
@SQLDelete(sql = "UPDATE incomes SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Income {

    @Id
    @SequenceGenerator(name = "incomeSequence",sequenceName = "incomeSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incomeSequence")
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "")
    private Double amount;

    private String description;

    @Column(nullable = false)
    @NotNull(message = "")
    private LocalDate date;

    private Boolean isIncluded;

    @Enumerated(EnumType.STRING)
    private EIncome type;

    @ManyToOne()
    @JoinColumn(name = "currency_id", referencedColumnName = "id", nullable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @NotNull(message = "")
    private Currency currency;

    private Boolean deleted = Boolean.FALSE;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @NotNull(message = "")
    private User user;
}
