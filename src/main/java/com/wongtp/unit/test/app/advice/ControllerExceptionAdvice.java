/*
 * Copyleft
 */
package com.wongtp.unit.test.app.advice;

import com.wongtp.unit.test.app.entity.response.Response;
import com.wongtp.unit.test.app.entity.response.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object exception(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        final StringBuilder strBuilder = new StringBuilder();
        Set<String> errorContentSet = new HashSet<>();
        for (FieldError fieldError : fieldErrors) {
            if (errorContentSet.add(fieldError.getDefaultMessage())) {
                if (strBuilder.length() > 1) {
                    strBuilder.append(" | ");
                }
                strBuilder.append(fieldError.getDefaultMessage());
            }
        }
        return Response.fail(ResponseCode.PARAM_NOT_VALID, strBuilder.toString());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object exception(Exception exception) {
        return Response.fail(ResponseCode.SYSTEM_ERROR);
    }
}
