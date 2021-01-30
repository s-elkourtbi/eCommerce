package com.poke.eCommerce.repository;

import com.poke.eCommerce.entities.ListProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListProductRepository extends JpaRepository<ListProduct, Long> {
}
