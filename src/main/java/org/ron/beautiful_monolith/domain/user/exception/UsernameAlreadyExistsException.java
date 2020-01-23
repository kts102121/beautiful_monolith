package org.ron.beautiful_monolith.domain.user.exception;

import org.ron.beautiful_monolith.common.exception.model.BusinessException;
import org.ron.beautiful_monolith.common.exception.model.ErrorCode;

public class UsernameAlreadyExistsException extends BusinessException {

    public UsernameAlreadyExistsException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public UsernameAlreadyExistsException(ErrorCode errorCode) {
        super(errorCode);
    }
}
