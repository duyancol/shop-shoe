package com.example.Shoe_Shop.Entity;


import com.example.Shoe_Shop.Repository.ProductRepository;
import com.example.Shoe_Shop.modelEmail.Email;
import com.example.Shoe_Shop.modelEmail.EmailUntilt;
import com.example.Shoe_Shop.Repository.CartItemRepository;
import com.example.Shoe_Shop.Repository.CartRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public void saveCart(String cartJson) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(cartJson, JsonObject.class);

        Cart cart = new Cart();
        cart.setCreatedAt(LocalDateTime.now());
        JsonObject cartJsonObject = jsonObject.getAsJsonObject("cart");
        cart.setUserID(cartJsonObject.get("userID").getAsString());
        cart.setAddress(cartJsonObject.get("address").getAsString());
        cart.setStatus(cartJsonObject.get("status").getAsString());
        cart.setPrice(cartJsonObject.get("price").getAsString());
        cart.setPhone(cartJsonObject.get("phone").getAsString());
        if(cartJsonObject==null){
            System.out.println("ra cái nay ne dm coc vl");
        }

        List<CartItem> cartItems = new ArrayList<>();

        JsonArray itemsJsonArray = jsonObject.getAsJsonArray("listProduct");
        for (int i = 0; i < itemsJsonArray.size(); i++) {
            JsonObject itemJsonObject = itemsJsonArray.get(i).getAsJsonObject();

            CartItem cartItem = new CartItem();
            cartItem.setName(itemJsonObject.get("name").getAsString());
            cartItem.setPrice(itemJsonObject.get("price").getAsDouble());
            cartItem.setQuantity(itemJsonObject.get("quantity").getAsInt());
            cartItem.setImg(itemJsonObject.get("img").getAsString());
            cartItem.setId_product(itemJsonObject.get("id").getAsInt());
            cartItem.setCart(cart);
//            String idcart=String.valueOf(cartItem.setId(itemJsonObject.get("id").getAsLong()));
//            Product p = productRepository.findById(Integer.parseInt(idcart)).orElse(null);
//            p.setQuantity(0);
//            productRepository.save(p);

            cartItems.add(cartItem);
        }

        cart.setCartItems(cartItems);



        cartRepository.save(cart);

        for (CartItem cartItem : cartItems) {
            String productId = String.valueOf(cartItem.getId_product());
            int quantity = cartItem.getQuantity();


            Product product = productRepository.findById(Integer.valueOf(productId)).orElse(null);

            int currentStock = product.getQuantity();
            int updatedStock = currentStock - quantity;
            product.setQuantity(updatedStock);


            productRepository.save(product);
            System.out.println(productId);

        }





        Email email1 = new Email();
        email1.setFrom("nguyenduy.30719@gmail.com");
        email1.setFromPss("iuntfgqwytqmwsvr");
        email1.setTo("19130057@st.hcmuaf.edu.vn");
        email1.setSubject("The order you have placed :");
        StringBuilder sb= new StringBuilder();
        sb.append("Cảm ơn bạn đã ủng hộ shop của chúng tôi").append("<br>");
        sb.append("Thông tin hóa đơn :").append("<br>");
        sb.append("-" + "  "+"Tên khách hàng : "+cartJsonObject.get("userID").getAsString()).append("<br>");
        sb.append("-" + "  "+"Địa chỉ : "+cartJsonObject.get("address").getAsString()).append("<br>");
        sb.append("-" + "  "+"Số điện thoại : "+cartJsonObject.get("phone").getAsString()).append("<br>");
        sb.append("-" + "  "+ "Product :").append("<br>");
        for (CartItem c :cartItems){

            sb.append("  ." + "  Name product: "+ c.getName() + "  ,Price : "+c.getPrice()+"  ,Quantity : "+c.getQuantity()).append("<br>");

        }
        sb.append("-" + "  "+"Total : "+ cartJsonObject.get("price").getAsString()).append("<br>");
        sb.append("-" +"  "+ "Đơn hàng của bạn sẽ đươc giao trong vài ngày tới. Mong bạn hãy giữ thông tin liên lạc . ").append("<br>");
        sb.append("-" + "  "+"Xin cảm ơn ! ").append("<br>");
        email1.setContent(sb.toString());
        try {
            EmailUntilt.send(email1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public CartDto getCartWithProductsByUserId(String userId) {
        List<Cart> cartList = cartRepository.findByUserCartID(userId);
        if (cartList.isEmpty()) {
            return null;
        }
        Cart cart = cartList.get(0);
        List<ProductDto> productDtoList = cart.getCartItems().stream()
                .map(item -> new ProductDto(item.getName(), item.getPrice(), item.getQuantity(), item.getImg()))
                .collect(Collectors.toList());
        return new CartDto(cart.getId(), cart.getUserID(), cart.getAddress(), cart.getStatus(), cart.getPrice(), cart.getPhone(),productDtoList);
    }

    //    public List<Cart> getCartWithOrderByDate(String date) {
//        List<Cart> cartList = cartRepository.findByOrderDateCartID(date);
//
//        Cart cart = cartList.get(0);
//        List<ProductDto> productDtoList = cart.getCartItems().stream()
//                .map(item -> new ProductDto(item.getName(), item.getPrice(), item.getQuantity(), item.getImg()))
//                .collect(Collectors.toList());
//        CartDto cartDto = new CartDto(cart.getId(), cart.getUserID(), cart.getAddress(), cart.getStatus(), cart.getPrice(), cart.getPhone(),productDtoList);
//        return cartList;
//    }
//    public List<CartDto> getCartsWithProductsByUserId(String date) {
//        List<Cart> cartList = cartRepository.findByOrderDateCartID(date);
//        List<CartDto> cartDtoList = new ArrayList<>();
//        for (Cart cart : cartList) {
//            List<ProductDto> productDtoList = cart.getCartItems().stream()
//                    .map(item -> new ProductDto(item.getName(), item.getPrice(), item.getQuantity(), item.getImg()))
//                    .collect(Collectors.toList());
//            cartDtoList.add(new CartDto(cart.getId(), cart.getUserID(), cart.getAddress(), cart.getStatus(), cart.getPrice(), cart.getPhone(), productDtoList));
//        }
//        return cartDtoList;
//    }


}