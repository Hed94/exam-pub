package com.example.tavern.dao;

import com.example.tavern.dto.SummaryAll;
import com.example.tavern.model.OrderedProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedProductsRepository extends JpaRepository<OrderedProducts, Long>
{
    @Query(value = "select product.product_name as productName," +
            "SUM(ordered_products.amount) as amountDrinked," +
            "product.price as unitPrice," +
            "(SUM(ordered_products.amount) * product.price ) as summaryPrice" +
            " from ordered_products inner join product ON ordered_products.product_id = product.id" +
            " GROUP BY ordered_products.product_id", nativeQuery = true)
    List<SummaryAll> sumAmount();

}
