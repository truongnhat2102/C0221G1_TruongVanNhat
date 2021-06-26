package com.product.model.repository;

import com.product.model.entity.CategoryProduct;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryProductRepository extends PagingAndSortingRepository<CategoryProduct, Long> {
}
