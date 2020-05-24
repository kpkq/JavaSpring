package com.example.exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class mainHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(mainHandler.class);

    @ExceptionHandler(notFoundProductException.class) // обработчик исключения notFoundProductException
    @ResponseBody
    public String notFindItemExceptionHandler(notFoundProductException ex, HttpServletRequest request) {
        LOGGER.warn(ex.getMessage() + ". Request URL: " + request.getRequestURL());            // вывод в консоль при помощи логгера
        return ex.getMessage() + ".\n Request URL: " + request.getRequestURL();
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class) // обработчик исключения запроса неверным методом
    @ResponseBody
    public String methodNotSupportedExceptionHandler(HttpServletRequest request) {
        LOGGER.warn(request.getMethod() + " method is not supported here: " + request.getRequestURL());    //вывод в консоль
        return request.getMethod() + " method is not supported here: " + request.getRequestURL(); // вывод сообщения об ошибке
    }                                                                                             // в формате МЕТОД + текст + URL
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String badRequestHandler(HttpMessageNotReadableException ex, HttpServletRequest request) {
        LOGGER.warn("JSON parse error. URL: " + request.getRequestURL());
        return "JSON parse error. URL: " + request.getRequestURL();
    }
}
