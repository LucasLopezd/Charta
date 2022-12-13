package com.wallet.wallet.domain.model;

import com.wallet.wallet.domain.enums.ERole;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@SQLDelete(sql = "UPDATE roles SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Role {

    @Id
    @SequenceGenerator(name = "roleSequence",sequenceName = "roleSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSequence")
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private ERole name;

    private Boolean deleted;
}
