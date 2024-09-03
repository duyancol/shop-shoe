package com.example.Shoe_Shop.Repository;

import com.example.Shoe_Shop.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
