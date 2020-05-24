package com.example.controllers;

import com.example.exceptions.notFoundProductException;
import com.example.model.Product;

import java.util.List;

public class findInList {
    public static int findPozByName(List<Product> lst, String name) throws notFoundProductException { // метод для поиска товара по названию.
                                                                   // возвращает его позицию в списке. бросает исключение
        for(int i = 0; i < lst.size(); i++) {                                         // при неудачной попытке найти товар.
            if (lst.get(i).getName().equals(name)) return i;
        }
        throw new notFoundProductException(name);
    }
}
