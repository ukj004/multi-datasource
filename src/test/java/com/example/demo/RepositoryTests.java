package com.example.demo;

import com.example.demo.datasource1.model.CustomerForDatasource1;
import com.example.demo.datasource1.repo.CustomerForDatasource1Repository;
import com.example.demo.datasource2.model.Order;
import com.example.demo.datasource2.repo.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RepositoryTests {

    @Autowired
    CustomerForDatasource1Repository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    R2dbcRepository<CustomerForDatasource1, Long> customers;

    @Autowired
    R2dbcRepository<Order, Long> orders;

    @Test
    public void testCustomerRepositoryExists() {
        assertThat(this.customerRepository).isNotNull();
    }

    @Test
    public void testOrderRepositoryExists() {
        assertThat(this.orderRepository).isNotNull();
    }

    @Test
    public void testCustomersExists() {
        assertThat(this.customers).isNotNull();
    }

    @Test
    public void testOrdersExists() {
        assertThat(this.orders).isNotNull();
    }
}
