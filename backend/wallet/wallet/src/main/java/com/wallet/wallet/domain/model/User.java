package com.wallet.wallet.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wallet.wallet.domain.enums.ERole;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Data
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class User {

    //Cristian

    @Id
    @SequenceGenerator(name = "userSequence",sequenceName = "userSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private Long id;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @ManyToOne()
    @JoinColumn(name = "currency_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @NotNull(message = "")
    private Currency currency;

    //@ManyToOne()
    //@JoinColumn(name = "languague_id", referencedColumnName = "id", nullable = false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@NotNull(message = "")
    //private Languague languague;

    private ERole role;

    private Boolean deleted;
}
