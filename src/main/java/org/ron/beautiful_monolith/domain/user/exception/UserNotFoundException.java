package org.ron.beautiful_monolith.domain.user.exception;

import org.ron.beautiful_monolith.common.exception.model.BusinessException;
import org.ron.beautiful_monolith.common.exception.model.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
