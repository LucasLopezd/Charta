package com.wallet.wallet.domain.model;

import com.wallet.wallet.domain.enums.ERoleAboutUs;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.wallet.wallet.domain.enums.ERoleAboutUs;

@Entity
@Table(name = "aboutUs")
@Data
public class AboutUs {

    @Id
    @SequenceGenerator(name = "aboutUsSequence",sequenceName = "aboutUsSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aboutUsSequence")
    private Long id;

    @NotNull
    private String nameComplete;

    @NotNull
    private String role;

    @NotNull
    private String description;

    @NotNull
    @Lob
    private String image;

    @NotNull
    private String email;

    private String linkedIn;

    private String behance;

    private String github;


}
