package com.amazon.pnl.repository;

import com.amazon.pnl.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // आप चाहें तो custom methods भी यहाँ जोड़ सकते हैं
    // Example: Optional<Product> findBySku(String sku);
}