package com.vinothit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinothit.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
