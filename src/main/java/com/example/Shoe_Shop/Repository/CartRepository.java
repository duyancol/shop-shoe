package com.example.Shoe_Shop.Repository;

import com.example.Shoe_Shop.Entity.Cart;
import com.example.Shoe_Shop.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
//    @Query("SELECT c FROM Cart c JOIN FETCH c.cartItems WHERE c.userID = :id")
//    List<Cart> findByUserID(@PathVariable("userID") String id);
//
//    @Query("SELECT c FROM Cart c JOIN FETCH c.cartItems WHERE c.id = :id")
//    List<Cart> findByUserCartID(@PathVariable("id") String id);
//
//    @Query("SELECT c FROM Cart c JOIN FETCH c.cartItems WHERE DATE_FORMAT(c.createdAt, '%Y-%m-%d') LIKE %:date% ")
//    List<Cart> findByOrderDateCartID(String date);
//
//    @Query("SELECT DISTINCT c FROM Cart c LEFT JOIN FETCH c.cartItems")
//    List<Cart> findAllWithItems();
//
//    @Query("SELECT c FROM Cart c WHERE DATE_FORMAT(c.createdAt, '%Y-%m-%d') LIKE %:date%")
//    List<Cart> findAllByCreatedAtLike(String date);
//
//    default List<Cart> findAllByCreatedAtLikeS(String date) {
//
//        return findAllByCreatedAtLike(date);
//    }

    // Tìm Cart theo userID
    @Query("SELECT c FROM Cart c JOIN FETCH c.cartItems WHERE c.userID = :id")
    List<Cart> findByUserID(@Param("id") String id);

    // Tìm Cart theo cartID
    @Query("SELECT c FROM Cart c JOIN FETCH c.cartItems WHERE c.id = :id")
    List<Cart> findByUserCartID(@Param("id") String id);

    // Tìm Cart theo ngày order, sử dụng LocalDateTime
//    @Query("SELECT c FROM Cart c JOIN FETCH c.cartItems WHERE FUNCTION('DATE_FORMAT', c.createdAt, '%Y-%m-%d') LIKE CONCAT(:date, '%')")
//    List<Cart> findByOrderDateCartID(@Param("date") String date);
//
//    // Lấy tất cả Cart kèm các CartItem
//    @Query("SELECT DISTINCT c FROM Cart c LEFT JOIN FETCH c.cartItems")
//    List<Cart> findAllWithItems();
//
//    // Tìm tất cả các Cart có ngày tạo giống với tham số
//    @Query("SELECT c FROM Cart c WHERE FUNCTION('DATE_FORMAT', c.createdAt, '%Y-%m-%d') LIKE CONCAT(:date, '%')")
//    List<Cart> findAllByCreatedAtLike(@Param("date") String date);
//
//    // Phương thức mặc định gọi lại phương thức tìm kiếm theo ngày
//    default List<Cart> findAllByCreatedAtLikeS(String date) {
//        return findAllByCreatedAtLike(date);
//    }
}

