/**
 * @Author Dou2am_Sagna
 *
 */
package com.modelsis.productservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlers
{

    @ExceptionHandler(ObjectNotValidException.class)
    public ResponseEntity<?> handleObjectNotValidExceptionException(ObjectNotValidException exception)
    {
        return ResponseEntity
                .badRequest()
                .body(String.join(" | ", exception.getErrorMessages()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException exception)
    {
        return ResponseEntity
                .notFound()
                .build();
    }

}
