package com.example.service.impl;

import com.example.entity.Product;
import com.example.exception.ProductAlreadyExists;
import com.example.exception.WrongIdException;
import com.example.service.ProductService;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private final Map<Integer, Product> products = new HashMap<>();

    @Override
    public void addProduct(Product product) throws ProductAlreadyExists {
        if (products.containsKey(product.getId())) {
            throw new ProductAlreadyExists("Product with id " + product.getId() + " already exists");
        }
        products.put(product.getId(), product);
    }

    @Override
    public void updateProduct(int id, String name, double price) throws WrongIdException {
        if (!products.containsKey(id)) {
            throw new WrongIdException("Product with id " + id + " does not exist");
        }
        Product product = products.get(id);
        product.setName(name);
        product.setPrice(price);
    }

    @Override
    public Product getProduct(int id) throws WrongIdException {
        if (!products.containsKey(id)) {
            throw new WrongIdException("Product with id " + id + " does not exist");
        }
        return products.get(id);
    }

    @Override
    public void displayAllProducts() {
        if (products.isEmpty()) {
            IO.println("There are no products in the database");
            return;
        }
        IO.println("=== Product List ===");
        products.values().forEach(IO::println);
    }

    @Override
    public void deleteProductById(int id) throws WrongIdException {
        if (!products.containsKey(id)) {
            throw new WrongIdException("Product with id " + id + " does not exist");
        }
        products.remove(id);
    }
}
