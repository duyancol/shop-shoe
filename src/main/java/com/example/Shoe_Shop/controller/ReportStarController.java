package com.example.Shoe_Shop.controller;

import com.example.Shoe_Shop.Entity.Product;
import com.example.Shoe_Shop.Repository.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Shoe_Shop.Repository.reportStartRepository;
import java.io.IOException;
import java.util.List;
import com.example.Shoe_Shop.modelEmail.reportStar;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class ReportStarController {
    @Autowired
    reportStartRepository reportStartRepository;
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/getReport/{id}/{iduser}")
    public Boolean getReportById(@PathVariable("id") String id , @PathVariable("iduser") String iduser){

        List<reportStar> re = reportStartRepository.findReprotByProductID(id);
        for (reportStar ca : re){
            if(ca.getProductID().equals(id)&& ca.getUserID().equals(iduser)){
                return true;
            }
        }
        return false;

    }
    @PostMapping("/addReportStar/{id}")
    public ResponseEntity<String> addReportStar(@RequestParam("userID") String userID,
                                                @PathVariable("id") String id,
                                                @RequestParam("report") double report,
                                                HttpServletRequest request) throws IOException {


        reportStar re = new reportStar(userID,id,report);
        reportStartRepository.save(re);
        double sum=0;
        int count = 0;

        List<reportStar> reList = reportStartRepository.findReprotByProductID(id);
        for (reportStar ca : reList){
            sum+=ca.getReport();
            count=reList.size();
        }
        Product product = productRepository.findById(Integer.valueOf(id)).orElse(null);


        product.setReportStart(String.valueOf(sum/count));


        productRepository.save(product);

        return ResponseEntity.ok("Thêm sản phẩm thành công!");

    }
}
