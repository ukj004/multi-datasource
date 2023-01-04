package com.example.demo.datasource2.service;

import com.example.demo.datasource2.model.CustomerForDatasource2;
import org.springframework.data.domain.Persistable;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Datasource2Service {

    Flux<? extends Persistable> getAllForDatasource2();
    Mono<? extends Persistable> getCacheByIdForDatasource2(Long id);
    Disposable putCacheForDatasource2(CustomerForDatasource2 object);
}
