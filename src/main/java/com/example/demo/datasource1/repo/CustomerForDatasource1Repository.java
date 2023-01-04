package com.example.demo.datasource1.repo;

import com.example.demo.datasource1.model.CustomerForDatasource1;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CustomerForDatasource1Repository extends R2dbcRepository<CustomerForDatasource1, Long> {
}
