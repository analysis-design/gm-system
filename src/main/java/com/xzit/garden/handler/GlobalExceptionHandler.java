package com.xzit.garden.handler;


import com.xzit.garden.bean.model.GlobalExceptionInfoModel;
import com.xzit.garden.exception.ObjectAlreadyExistException;
import com.xzit.garden.exception.ObjectAlreadyInUseException;
import com.xzit.garden.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public GlobalExceptionInfoModel<String> exception(HttpServletRequest request, Exception e) {

        e.printStackTrace();

        return GlobalExceptionInfoModel.<String>builder()
                .code(1)
                .msg(e.getMessage())
                .data(e.getClass().getSimpleName())
                .uri(request.getRequestURI()).build();
    }


    @ExceptionHandler({ObjectAlreadyExistException.class, ObjectNotFoundException.class,
            ObjectAlreadyInUseException.class})
    @ResponseStatus(HttpStatus.OK)
    public GlobalExceptionInfoModel<String> exceptionForService(HttpServletRequest request, RuntimeException e) {
        e.printStackTrace();

        return GlobalExceptionInfoModel.<String>builder()
                .code(1)
                .msg(e.getMessage())
                .data(e.getClass().getSimpleName())
                .uri(request.getRequestURI()).build();
    }
}
