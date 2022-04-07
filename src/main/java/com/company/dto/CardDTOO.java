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
public class CardDTOO {
    private Integer id;
    @NotEmpty(message = "Number is Null or is Empty")
    private String number;
    @NotEmpty(message = "excDate is Null or is Empty")
    private String excDate;
    private Long balance; // in (tiyin)
    @Positive
    private Integer profileId;
    private LocalDateTime createdDate;
}
