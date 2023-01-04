package com.example.demo.datasource2.service.impl;

import com.example.demo.datasource2.model.CustomerForDatasource2;
import com.example.demo.datasource2.repo.CustomerForDatasource2Repository;
import com.example.demo.datasource2.service.Datasource2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class Datasource2ServiceImpl implements Datasource2Service {
    @Autowired
    CustomerForDatasource2Repository customerForDatasource2Repository;

    @Override
    public Flux<? extends Persistable> getAllForDatasource2() {
        return this.customerForDatasource2Repository.findAll();
    }

    @Override
    public Mono<? extends Persistable> getCacheByIdForDatasource2(Long id) {
        return this.customerForDatasource2Repository.findById(id);
    }

    @Override
    public Disposable putCacheForDatasource2(CustomerForDatasource2 customerForDatasource2) {
        return this.customerForDatasource2Repository.save(customerForDatasource2.setAsNew()).subscribe();
    }
}
