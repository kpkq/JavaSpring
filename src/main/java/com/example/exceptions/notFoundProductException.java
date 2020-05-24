package com.example.exceptions;

import java.util.Date;

public class notFoundProductException extends Throwable {
    private String productName;
    public notFoundProductException(String productName) {
        this.productName = productName;
    }

    public String getMessage() {
        return new Date() + ": Not found product with name: " + productName;
    }
}
