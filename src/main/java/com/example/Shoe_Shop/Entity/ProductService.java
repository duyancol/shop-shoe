package com.example.Shoe_Shop.Entity;

import com.example.Shoe_Shop.Repository.ProductRepository;
import com.example.Shoe_Shop.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepository;


    @Autowired private ProductDao productDao;
    public List<Product> listAll(){
        return  productDao.load3ProductNew();

    }
    public List<Product> listAllProduct(){
        return  productDao.loadAllproduct();

    }
    public List<Product> findByName(int count,int limit) {
        return productDao.load3ProductNext(count,limit);
    }
    public Product findByProductId(int id){

        Product optionalProduct = productDao.getProductById(id);
        return  optionalProduct;
    }

}

