package com.amazon.pnl.controller;

import com.amazon.pnl.model.Product;
import com.amazon.pnl.model.ProductVariant;
import com.amazon.pnl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // 🔹 1. Add Product with Variants
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        for (ProductVariant variant : product.getVariants()) {
            variant.setProduct(product); // link each variant to main product
        }
        return productRepository.save(product);
    }

    // 🔹 2. Get All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 🔹 3. Get Product by ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    // 🔹 4. Delete Product by ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
