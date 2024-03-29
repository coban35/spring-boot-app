package com.app.user.exception;

import com.app.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler(UserException.class)
    public final ResponseEntity<ApiResponse> userException() {
        ApiResponse apiResponse = new ApiResponse(new Date(), "500", "An error occurred.");
        LOGGER.error("An error occurred.");
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public final ResponseEntity<ApiResponse> userIdNotFoundException() {
        ApiResponse apiResponse = new ApiResponse(new Date(), "404", "User Id Not Found.");
        LOGGER.error("User Id Not Found.");
        return new ResponseEntity<>(apiResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(UserCannotBeDeletedException.class)
    public final ResponseEntity<ApiResponse> userCannotBeDeletedException() {
        ApiResponse apiResponse = new ApiResponse(new Date(), "405", "User Cannot Be Deleted.");
        LOGGER.error("User Cannot Be Deleted.");
        return new ResponseEntity<>(apiResponse, HttpStatus.EXPECTATION_FAILED);
    }

}
