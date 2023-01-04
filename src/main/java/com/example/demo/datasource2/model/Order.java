package com.example.demo.datasource2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.*;

import java.io.Serializable;

@Table(value = "ORDERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Persistable,Serializable {

    public Long getId() {
        return id;
    }

    @Id
    private Long id;

    private Long customerId;

    private Long amount;

    @Transient
    private boolean newProduct;

    @Override
    @Transient
    public boolean isNew() {
        return this.newProduct || id == null;
    }

    public Order setAsNew(){
        this.newProduct = true;
        return this;
    }
}
