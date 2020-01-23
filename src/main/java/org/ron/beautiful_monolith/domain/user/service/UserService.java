package org.ron.beautiful_monolith.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.ron.beautiful_monolith.common.exception.model.ErrorCode;
import org.ron.beautiful_monolith.common.exception.model.ResourceNotFoundException;
import org.ron.beautiful_monolith.domain.user.entity.User;
import org.ron.beautiful_monolith.domain.user.exception.UserNotFoundException;
import org.ron.beautiful_monolith.domain.user.exception.UsernameAlreadyExistsException;
import org.ron.beautiful_monolith.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User does not exist", ErrorCode.USER_NOT_FOUND));
    }

    public User saveUser(User user) {
        userRepository.findByUsername(user.getUsername())
                .ifPresent(result -> {throw new UsernameAlreadyExistsException("Username " + result.getUsername() + " already exists.", ErrorCode.USERNAME_DUPLICATION);});

        return userRepository.save(user);
    }
}
