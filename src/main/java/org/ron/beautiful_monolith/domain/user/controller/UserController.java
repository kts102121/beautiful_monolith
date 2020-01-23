package org.ron.beautiful_monolith.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.ron.beautiful_monolith.common.mapper.UserMapper;
import org.ron.beautiful_monolith.domain.user.dto.UserDTO;
import org.ron.beautiful_monolith.domain.user.entity.User;
import org.ron.beautiful_monolith.domain.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> findAllUsers() {
        return UserMapper.INSTANCE.toUserDtoList(userService.findAllUser());
    }

    @GetMapping(path = "{id}")
    public UserDTO findUserById(final @PathVariable Long id) {
        return UserMapper.INSTANCE.userToUserDto(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(final @Validated @RequestBody UserDTO userDto) {
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);

        return new ResponseEntity<>(UserMapper.INSTANCE.userToUserDto(userService.saveUser(user)), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Void> updateUser(final @Validated @RequestBody UserDTO userDto) {
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        userService.saveUser(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
