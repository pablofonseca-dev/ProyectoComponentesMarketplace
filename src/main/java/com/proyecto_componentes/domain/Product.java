package com.proyecto_componentes.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String uuid;
    @PartitionKey
    private String userId;
    private String name;
    private String description;
    private double price;
    private LocalDateTime createdDate;

    public Product() {}

    public Product(String userId, String name, String description, double price) {
        this.uuid = UUID.randomUUID().toString();
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdDate = LocalDateTime.now();
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "uuid='" + getUuid() + '\'' +
                ", userId='" + getUserId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                ", createdDate=" + getCreatedDate() +
                '}';
    }
}
