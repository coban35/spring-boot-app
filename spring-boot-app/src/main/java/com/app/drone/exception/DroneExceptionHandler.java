package com.app.drone.exception;

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
public class DroneExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DroneExceptionHandler.class);

    @ExceptionHandler(DroneException.class)
    public final ResponseEntity<ApiResponse> droneException() {
        ApiResponse apiResponse = new ApiResponse(new Date(), "500", "An error occurred.");
        LOGGER.error("An error occurred.");
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DroneIdNotFoundException.class)
    public final ResponseEntity<ApiResponse> droneIdNotFoundException() {
        ApiResponse apiResponse = new ApiResponse(new Date(), "404", "Drone Id Not Found.");
        LOGGER.error("Drone Id Not Found.");
        return new ResponseEntity<>(apiResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(DroneAlreadyRentedException.class)
    public final ResponseEntity<ApiResponse> droneAlreadyRentedException() {
        ApiResponse apiResponse = new ApiResponse(new Date(), "405", "Drone Already Rented.");
        LOGGER.error("Drone Already Rented.");
        return new ResponseEntity<>(apiResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(DroneAlreadyAvailableException.class)
    public final ResponseEntity<ApiResponse> droneAlreadyAvailableException() {
        ApiResponse apiResponse = new ApiResponse(new Date(), "406", "Drone Already Available.");
        LOGGER.error("Drone Already Available.");
        return new ResponseEntity<>(apiResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(DroneIsOnDifferentUserException.class)
    public final ResponseEntity<ApiResponse> droneIsOnDifferentUserException() {
        ApiResponse apiResponse = new ApiResponse(new Date(), "407", "Drone Is On Different User.");
        LOGGER.error("Drone Is On Different User.");
        return new ResponseEntity<>(apiResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(DroneCannotBeDeletedException.class)
    public final ResponseEntity<ApiResponse> droneCannotBeDeletedException() {
        ApiResponse apiResponse = new ApiResponse(new Date(), "408", "Drone cannot be deleted.");
        LOGGER.error("Drone cannot be deleted.");
        return new ResponseEntity<>(apiResponse, HttpStatus.EXPECTATION_FAILED);
    }

}
