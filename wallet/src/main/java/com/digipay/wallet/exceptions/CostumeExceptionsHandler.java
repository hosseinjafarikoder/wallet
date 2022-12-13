package com.digipay.wallet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CostumeExceptionsHandler {
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ExceptionData> badRequest(BadRequestException ex) {
        ExceptionData dataEx = new ExceptionData(ex.getMessage(), HttpStatus.BAD_REQUEST
                , ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(dataEx, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NotFoundExceptions.class)
    public ResponseEntity<ExceptionData> notFoundException(NotFoundExceptions ex) {
        ExceptionData dataEx = new ExceptionData(
                ex.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(dataEx, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = IdNullException.class)
    public ResponseEntity<ExceptionData> idNullEx(IdNullException ex){
        ExceptionData exData = new ExceptionData(
                ex.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("z"))
        );
        return new ResponseEntity<>(exData , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = walletIdNullException.class)
    public ResponseEntity<ExceptionData> walletIdNullEx(walletIdNullException ex){
        ExceptionData exData = new ExceptionData(
                ex.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("z"))
        );
        return new ResponseEntity<>(exData , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = walletNotActiveException.class)
    public ResponseEntity<ExceptionData> walletNotActive(walletNotActiveException ex){
        ExceptionData exData = new ExceptionData(
                ex.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("z"))
        );
        return new ResponseEntity<>(exData , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NotEnoughBalanceException.class)
    public ResponseEntity<ExceptionData> notEnoughBalance(NotEnoughBalanceException ex){
        ExceptionData exData = new ExceptionData(
                ex.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("z"))
        );
        return new ResponseEntity<>(exData , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ExceptionData> baseExceptionHandler(BaseException ex) {
        ExceptionData dataEx = new ExceptionData(
                ex.getExceptionType(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(dataEx, HttpStatus.BAD_REQUEST);
    }
}
