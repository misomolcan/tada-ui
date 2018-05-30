package com.zidan.fasic.tada.ui.db.repository;

import com.zidan.fasic.tada.ui.db.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
