package com.testepic.infra;


import com.testepic.DTO.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity duplicatedEntry(DataIntegrityViolationException e) {
        ExceptionDTO exception = new ExceptionDTO("Usuário já cadastrado!", "400");
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFound(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity generalException(Exception e) {
        ExceptionDTO exception = new ExceptionDTO(e.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exception);
    }

}
