package org.ron.beautiful_monolith.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.ron.beautiful_monolith.common.exception.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
/*    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(100, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { DuplicatedResourceException.class })
    public ResponseEntity<ErrorResponse> handleDuplicatedResourceException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(101, ex.getMessage()), HttpStatus.CONFLICT);
    }*/

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {
        log.error("handleEntityNotFoundException", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }
}
