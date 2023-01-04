package com.example.demo.datasource1.service;

import com.example.demo.datasource1.model.CustomerForDatasource1;
import org.springframework.data.domain.Persistable;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Datasource1Service {

    Flux<? extends Persistable> getAllForDatasource1();
    Mono<? extends Persistable> getCacheByIdForDatasource1(Long id);
    Disposable putCacheForDatasource1(CustomerForDatasource1 object);
}
