package com.myapp.exceptions;

import java.util.Date;

public class NotFoundItemException extends Throwable {
    private String productName;
    public NotFoundItemException(String productName) {
        this.productName = productName;
    }

    public String getMessage() {
        return new Date() + ": Not found product with name: " + productName;
    }
}
