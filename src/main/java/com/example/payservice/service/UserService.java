package com.example.payservice.service;

import com.example.payservice.domain.User;
import com.example.payservice.domain.dto.UserCreateDto;
import com.example.payservice.domain.dto.UserDetailDto;
import com.example.payservice.domain.dto.UserListDto;
import com.example.payservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserCreateDto userCreateDto) {
        User user = User.builder()
                .name(userCreateDto.getName())
                .pwd(userCreateDto.getPwd())
                .createdAt(LocalDateTime.now())
                .views(0L)
                .point(0L)
                .build();
        userRepository.save(user);
    }

    public Page<UserListDto> findAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);

        return users.map(UserListDto::new);
    }

    public UserDetailDto getUserById(Long id) {
        return null;
    }
}
