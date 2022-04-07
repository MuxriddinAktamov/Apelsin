package com.company.dto;

import com.company.enums.ProfileRole;
import com.company.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    private Integer id;
    @NotEmpty(message = "name is Null or is Empty")
    private String name;
    @NotEmpty(message = "surname is Null or is Empty")
    private String surname;
    @NotEmpty(message = "Login is Null or is Empty")
    @Size(min = 5, max = 15, message = "Login 5-15 oralig'ida bo'lsa kerak")
    private String login;
    @NotEmpty(message = "password is Null or is Empty")
    @Size(min = 5, max = 15, message = "password 5-15 oralig'ida bo'lsa kerak")
    private String pswd;
    @NotEmpty(message = "Phone is NUll or is Empty")
    private String phone;

    @NotEmpty(message = "Role is NUll or is Empty")
    private ProfileRole
            role;

    private String jwt;

    private ProfileStatus status;

    @Positive
    private LocalDateTime createdDate;
}
