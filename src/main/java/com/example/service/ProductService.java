package com.example.service;

import com.example.entity.Product;
import com.example.exception.ProductAlreadyExists;
import com.example.exception.WrongIdException;

public interface ProductService {
    void addProduct(Product product) throws ProductAlreadyExists;
    void updateProduct(int id,String name,double price) throws WrongIdException;
    Product getProduct(int id) throws WrongIdException;
    void displayAllProducts();
    void deleteProductById(int id) throws WrongIdException;
}

