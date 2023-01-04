package com.example.demo.datasource2.repo;

import com.example.demo.datasource2.model.CustomerForDatasource2;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CustomerForDatasource2Repository extends R2dbcRepository<CustomerForDatasource2,Long> {
}
