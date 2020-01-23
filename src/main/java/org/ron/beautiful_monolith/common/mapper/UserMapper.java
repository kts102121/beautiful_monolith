package org.ron.beautiful_monolith.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ron.beautiful_monolith.domain.user.dto.UserDTO;
import org.ron.beautiful_monolith.domain.user.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDto(User user);

    User userDtoToUser(UserDTO userDTO);

    List<UserDTO> toUserDtoList(List<User> users);
}
