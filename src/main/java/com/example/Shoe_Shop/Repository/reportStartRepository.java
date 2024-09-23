package com.example.Shoe_Shop.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.Shoe_Shop.modelEmail.reportStar;

import java.util.List;

public interface reportStartRepository extends CrudRepository<reportStar,Integer> {
    @Query("SELECT c FROM reportStar c WHERE c.productID= :productID")
    List<reportStar> findReprotByProductID(String productID);
}
