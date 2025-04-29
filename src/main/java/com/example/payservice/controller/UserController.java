package com.example.payservice.controller;

import com.example.payservice.domain.dto.UserCreateDto;
import com.example.payservice.domain.dto.UserDetailDto;
import com.example.payservice.domain.dto.UserListDto;
import com.example.payservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
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

        return new ResponseEntity<>("유저 등록 완료", HttpStatus.CREATED);
    }

    // 유저 프로필 목록 조회 api
    @GetMapping("/list")
    public ResponseEntity<?> getUsers(
            @SortDefault.SortDefaults({@SortDefault(sort = "name", direction = Sort.Direction.ASC)
                                        ,@SortDefault(sort = "views", direction = Sort.Direction.ASC)
                                        ,@SortDefault(sort = "createdAt", direction = Sort.Direction.DESC)
                                    }) Pageable pageable) {
        Page<UserListDto> userProfileList = userService.findAllUsers(pageable);
        return new ResponseEntity<>(userProfileList, HttpStatus.OK);
    }

}
