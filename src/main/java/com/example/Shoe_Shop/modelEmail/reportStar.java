package com.example.Shoe_Shop.modelEmail;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "report")

public class reportStar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userID;
    private String productID;

    private Double report;
    private LocalDateTime createdAt;

    public reportStar(Long id, String userID,String productID, Double report, LocalDateTime createdAt) {
        this.id = id;
        this.userID = userID;
        this.productID = productID;
        this.report = report;
        this.createdAt = createdAt;
    }

    public reportStar(String userID, String productID, Double report) {
        this.userID = userID;
        this.productID = productID;
        this.report = report;
    }

    public reportStar() {
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Double getReport() {
        return report;
    }

    public void setReport(Double report) {
        this.report = report;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
