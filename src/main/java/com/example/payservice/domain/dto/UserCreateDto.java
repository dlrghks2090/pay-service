package com.example.payservice.domain.dto;

import com.example.payservice.domain.User;
import lombok.Data;

@Data
public class UserCreateDto {
    private String name;
    private String pwd;
}
