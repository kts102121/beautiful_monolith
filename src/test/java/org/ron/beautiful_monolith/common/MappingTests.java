package org.ron.beautiful_monolith.common;

import org.junit.jupiter.api.Test;
import org.ron.beautiful_monolith.common.mapper.UserMapper;
import org.ron.beautiful_monolith.domain.user.dto.UserDTO;
import org.ron.beautiful_monolith.domain.user.entity.User;
import org.ron.beautiful_monolith.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class MappingTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldMapUserToUserDto() {
        // given
        User user = User.ByUserUsername()
                .username("kts1021")
                .build();

        // when
        UserDTO userDto = UserMapper.INSTANCE.userToUserDto(user);

        // then
        assertNotNull(userDto);
        assertEquals(user.getUsername(), userDto.getUsername());
    }

    @Test
    @Transactional
    public void shouldMapUserDtoToUser() {
        // given
        UserDTO userDTO = UserDTO.builder()
                .id(null)
                .username("kts1021c")
                .build();

        // when
        User user = userRepository.save(UserMapper.INSTANCE.userDtoToUser(userDTO));

        // then
        assertNotNull(user);
        assertEquals(user.getUsername(), userRepository.findByUsername("kts1021c").get().getUsername());
    }
}
