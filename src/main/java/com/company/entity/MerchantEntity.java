package com.company.entity;

import com.company.enums.MerchantStatus;
import com.company.enums.ProfileStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "merchant")
@ToString
public class MerchantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MerchantStatus status;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
