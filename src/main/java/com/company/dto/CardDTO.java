package com.company.dto;

import com.company.entity.ProfileEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CardDTO {
    private Integer id;
    private String name;
    @Column(name = "number", nullable = false, unique = true)
    private String number;
    @Column(name = "exc_date")
    private String excDate;
    @Column(name = "balance")
    private Long balance; // in (tiyin)

    @Column(name = "profile_id", nullable = false)
    private Integer profileId;
    private LocalDateTime createdDate;
}
