package com.example.demo.datasource1.service.impl;

import com.example.demo.datasource1.model.CustomerForDatasource1;
import com.example.demo.datasource1.repo.CustomerForDatasource1Repository;
import com.example.demo.datasource1.service.Datasource1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class Datasource1ServiceImpl implements Datasource1Service {
    @Autowired
    CustomerForDatasource1Repository customerForDatasource1Repository;

    @Override
    public Flux<? extends Persistable> getAllForDatasource1() {
        return this.customerForDatasource1Repository.findAll();
    }

    @Override
    public Mono<? extends Persistable> getCacheByIdForDatasource1(Long id) {
        return this.customerForDatasource1Repository.findById(id);
    }

    @Override
    public Disposable putCacheForDatasource1(CustomerForDatasource1 customerForDatasource1) {
        return this.customerForDatasource1Repository.save(customerForDatasource1.setAsNew()).subscribe();
    }
}
