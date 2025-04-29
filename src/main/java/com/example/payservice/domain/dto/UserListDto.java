package com.example.payservice.domain.dto;

import com.example.payservice.domain.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserListDto {

    private String name;
    private Long views;
    private LocalDateTime createdAt;

    public UserListDto(User uesr) {
        this.name = uesr.getName();
        this.views = uesr.getViews();
        this.createdAt = uesr.getCreatedAt();
    }
}
