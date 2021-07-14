package com.melvinrabang.parcel.delivery.controller.advice;

import com.melvinrabang.parcel.delivery.controller.ParcelDeliveryCostController;
import com.melvinrabang.parcel.delivery.dto.ExceptionResponse;
import com.melvinrabang.parcel.delivery.exception.WeightTooHeavyException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice(basePackageClasses = ParcelDeliveryCostController.class)
@RequiredArgsConstructor
public class ParcelDeliveryCostControllerAdvice {

    private final MessageSource messageSource;

    @ExceptionHandler(WeightTooHeavyException.class)
    public ResponseEntity<ExceptionResponse> handleWeightTooHeavyException(Exception e) {
        return new ResponseEntity<>(ExceptionResponse.builder()
                .errorMessage(messageSource.getMessage("weight.too_heavy_exception", null,
                        LocaleContextHolder.getLocale()))
                .build(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
