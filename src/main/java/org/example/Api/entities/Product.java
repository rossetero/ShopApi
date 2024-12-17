package org.example.Api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @NotNull
    private UUID id;
    private String name;
    private String category;
    private Double price;
    @Column(name = "available_stock")
    private Integer availableStock;
    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;
    @Column(name = "supplier_id")
    private UUID supplierId;
    @Column(name = "image_id")
    private UUID imageId;

    public Product(UUID id, String name, String category, Double price, Integer availableStock, LocalDate lastUpdateDate, UUID supplierId, UUID imageId) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.availableStock = availableStock;
        this.lastUpdateDate = lastUpdateDate;
        this.supplierId = supplierId;
        this.imageId = imageId;
    }

    // Геттеры и сеттеры
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public UUID getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(UUID supplierId) {
        this.supplierId = supplierId;
    }

    public UUID getImageId() {
        return imageId;
    }

    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }

    // Перегрузка метода toString
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", availableStock=" + availableStock +
                ", lastUpdateDate=" + lastUpdateDate +
                ", supplierId=" + supplierId +
                ", imageId=" + imageId +
                '}';
    }

    // Реализация метода equals
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Product otherProduct = (Product) other;
        return Objects.equals(this.id, otherProduct.id)
                && Objects.equals(this.name, otherProduct.name)
                && Objects.equals(this.category, otherProduct.category)
                && Objects.equals(this.price, otherProduct.price)
                && Objects.equals(this.availableStock, otherProduct.availableStock)
                && Objects.equals(this.lastUpdateDate, otherProduct.lastUpdateDate)
                && Objects.equals(this.supplierId, otherProduct.supplierId)
                && Objects.equals(this.imageId, otherProduct.imageId);
    }

    // Реализация метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price, availableStock, lastUpdateDate, supplierId, imageId);
    }
}
