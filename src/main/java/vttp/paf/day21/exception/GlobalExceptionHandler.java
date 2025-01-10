package vttp.paf.day21.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vttp.paf.day21.model.Exception.ApiError;
import vttp.paf.day21.model.Exception.ResourceNotFoundException;

import java.util.Date;

// @ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) {
        ApiError apiError = new ApiError(response.getStatus(),ex.getMessage(),new Date());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ApiError> handleDataAccessException(DataAccessException ex,
                                                                   HttpServletRequest request,
                                                                   HttpServletResponse response) {
        ApiError apiError = new ApiError(response.getStatus(), ex.getMessage(),new Date());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException ex,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) {
        ApiError apiError = new ApiError(response.getStatus(),ex.getMessage(),new Date());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleException(ResourceNotFoundException ex,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(),ex.getMessage(),new Date());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }
}
