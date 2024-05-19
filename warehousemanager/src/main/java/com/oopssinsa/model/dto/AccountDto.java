package com.oopssinsa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountDto {
    private String id;
    private String password;
    private String role;
}
