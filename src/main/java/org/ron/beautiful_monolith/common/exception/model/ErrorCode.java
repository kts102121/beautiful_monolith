package org.ron.beautiful_monolith.common.exception.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    USERNAME_DUPLICATION(409, "U001", "Username already exists"),
    USER_NOT_FOUND(404, "U002", "User does not exists");

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
