package com.myapp.exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class MainHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainHandler.class);

    @ExceptionHandler(NotFoundItemException.class) // обработчик исключения notFoundProductException
    @ResponseBody
    public String notFoundItemExceptionHandler(NotFoundItemException ex, HttpServletRequest request) {
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
    @ExceptionHandler(org.springframework.dao.EmptyResultDataAccessException.class) // обработчик для ошибочной попытки удалить из бд
    @ResponseBody
    public String notFoundedSuchElementInDatabase(HttpServletRequest request) {
        LOGGER.warn(". Request URL: " + request.getRequestURL());
        return "Not found such element in database please try again";
    }
}