package org.example.handlers;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.example.objects.SimpleWebDataEntryErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
/*
 * The following class is used to handle generic errors that could
 * occur when a user does not give enough information or an endpoint
 * is hit manually.
 */
public class SimpleWebDataEntryErrorHandler extends ResponseEntityExceptionHandler {
    @Override
    @NonNull
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        log.error("Rest method not supported: {}", ex.getMessage());
        SimpleWebDataEntryErrorResponse errorResponse = new SimpleWebDataEntryErrorResponse("Rest method not allowed for this resource.", ex.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

    @Override
    @NonNull
    public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        log.error("Resource not found: {}", ex.getMessage());
        SimpleWebDataEntryErrorResponse errorResponse = new SimpleWebDataEntryErrorResponse("Resource not found.", ex.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

    @Override
    @NonNull
    public ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        log.error("Path variable missing: {}", ex.getMessage());
        SimpleWebDataEntryErrorResponse errorResponse = new SimpleWebDataEntryErrorResponse("Required path variable missing.", ex.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

    @Override
    @NonNull
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        log.error("Bad request exception: {}", ex.getMessage());
        SimpleWebDataEntryErrorResponse errorResponse = new SimpleWebDataEntryErrorResponse("Bad request.", ex.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        log.error("Path variable missing: {}", ex.getMessage());
        SimpleWebDataEntryErrorResponse errorResponse = new SimpleWebDataEntryErrorResponse("Required path variable missing.", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        log.error("Internal error: {}", ex.getMessage());
        SimpleWebDataEntryErrorResponse errorResponse = new SimpleWebDataEntryErrorResponse("Internal error.", ex.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }
}
