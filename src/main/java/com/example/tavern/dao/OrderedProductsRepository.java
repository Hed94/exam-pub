package com.example.tavern.dao;

import com.example.tavern.model.OrderedProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedProductsRepository extends JpaRepository<OrderedProducts, Long> {
}
