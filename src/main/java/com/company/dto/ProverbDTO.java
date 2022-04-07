package com.company.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class ProverbDTO {
    private Integer id;
    private String number;
    private String excDate;
    private Long balance; // in (tiyin)
    private Integer profileId;
    private LocalDateTime createdDate;
}
