package org.ron.beautiful_monolith.domain.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString(of = { "" })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class UserDTO {
    private Long id;
    private String username;

    private UserDTO(Builder builder) {
        id = builder.id;
        username = builder.username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public static UserDTO.Builder builder() {
        return new UserDTO.Builder();
    }

    public static class Builder {
        private Long id;
        private String username;

        Builder() {
        }

        public UserDTO.Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public UserDTO.Builder username(final String username) {
            this.username = username;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }
}
