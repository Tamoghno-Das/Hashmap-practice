package com.example.main;

import com.example.entity.Product;
import com.example.exception.ProductAlreadyExists;
import com.example.exception.WrongIdException;
import com.example.service.impl.ProductServiceImpl;

public class ProductManagement {
    static void main() {
        ProductServiceImpl ps = new ProductServiceImpl();

        while (true) {
            IO.println("===== Product Management Menu =====");
            IO.println("1. Add Product");
            IO.println("2. View Product by ID");
            IO.println("3. Update Product");
            IO.println("4. Delete Product");
            IO.println("5. Display All Products");
            IO.println("6. Exit");
            IO.println("Enter choice: ");
            int choice = Integer.parseInt(IO.readln());

            try {
                switch (choice) {
                    case 1 -> {
                        IO.println("Enter Product ID: ");
                        int id = Integer.parseInt(IO.readln());
                        IO.println("Enter Product Name: ");
                        String name = IO.readln();
                        IO.println("Enter Product Price: ");
                        double price = Double.parseDouble(IO.readln());
                        try {
                            ps.addProduct(new Product(id, name, price));
                            IO.println("Product successfully added!");
                        } catch (ProductAlreadyExists e) {
                            IO.println(e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            IO.println("Enter Product ID: ");
                            int id = Integer.parseInt(IO.readln());
                            IO.println(ps.getProduct(id));
                        } catch (WrongIdException e) {
                            IO.println(e.getMessage());
                        }
                    }
                    case 3 -> {
                        IO.println("Enter Product ID: ");
                        int id = Integer.parseInt(IO.readln());
                        IO.println("Enter new Product Name: ");
                        String name = IO.readln();
                        IO.println("Enter new Product Price: ");
                        double price = Double.parseDouble(IO.readln());
                        try {
                            ps.updateProduct(id, name, price);
                            IO.println("Product successfully updated!");
                        } catch (WrongIdException e) {
                            IO.println(e.getMessage());
                        }
                    }
                    case 4 -> {
                        try {
                            IO.println("Enter Product ID: ");
                            int id = Integer.parseInt(IO.readln());
                            ps.deleteProductById(id);
                            IO.println("Product successfully deleted!");
                        } catch (WrongIdException e) {
                            IO.println(e.getMessage());
                        }
                    }
                    case 5 -> ps.displayAllProducts();

                    case 6 -> {
                        IO.println("Thank you for using our product!");
                        System.exit(0);
                    }
                    default -> IO.println("Invalid choice, try again.");
                }

            } catch (Exception e) {
                IO.println("Error: " + e.getMessage());
            }
        }
    }
}
