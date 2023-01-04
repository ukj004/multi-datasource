package com.example.demo.datasource2.repo;

import com.example.demo.datasource2.model.Order;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface OrderRepository extends R2dbcRepository<Order,Long> {
}
