package br.com.usersapi.builders;

import br.com.usersapi.domain.User;
import br.com.usersapi.dtos.UserRequestDTO;
import br.com.usersapi.dtos.UserViewDTO;
import br.com.usersapi.utilities.ConvertUtil;

public class UserBuilder {

    public static User build(UserRequestDTO requestDTO) {
        return User.builder()
                .id(ConvertUtil.convertStringToUUID(requestDTO.getId()))
                .name(requestDTO.getName())
                .key(requestDTO.getKey())
                .email(requestDTO.getEmail())
                .build();
    }

    public static UserViewDTO build(User user) {
        return UserViewDTO.builder()
                .id(ConvertUtil.convertUUIDToString(user.getId()))
                .name(user.getName())
                .key(user.getKey())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
