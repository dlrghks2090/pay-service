package com.example.payservice.service;

import com.example.payservice.domain.dto.UserCreateDto;
import com.example.payservice.domain.dto.UserDetailDto;
import com.example.payservice.domain.dto.UserListDto;

public interface UserService {
    UserDetailDto createUser(UserCreateDto userCreateDto);

    UserListDto getUserByAll();
    UserDetailDto getUserById(Long id);
}
