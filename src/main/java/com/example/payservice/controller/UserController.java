package com.example.payservice.controller;

import com.example.payservice.domain.dto.UserCreateDto;
import com.example.payservice.domain.dto.UserDetailDto;
import com.example.payservice.domain.dto.UserListDto;
import com.example.payservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    // 유저 생성(가입)
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserCreateDto userCreateDto) {

        userService.createUser(userCreateDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("유저 등록 완료");
    }

//    // 유저 프로필 목록 조회 api
//    @GetMapping("/list")
//    public ResponseEntity<List<UserListDto>> getUsers() {
//
//        return ResponseEntity.status(HttpStatus.OK).body();
//    }

}
