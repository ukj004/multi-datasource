package com.example.demo.datasource1;

import com.example.demo.datasource1.model.CustomerForDatasource1;
import com.example.demo.datasource1.repo.CustomerForDatasource1Repository;
import com.example.demo.datasource1.service.Datasource1Service;
import com.example.demo.datasource2.model.CustomerForDatasource2;
import com.example.demo.datasource2.repo.CustomerForDatasource2Repository;
import com.example.demo.datasource2.repo.OrderRepository;
import com.example.demo.datasource2.service.Datasource2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    Datasource1Service datasource1Service;

    @Autowired
    Datasource2Service datasource2Service;

    @GetMapping("/getAll/{datasourceType}")
    public ResponseEntity<Flux<? extends Persistable>> all(@PathVariable int datasourceType) {
        try {
            if(datasourceType == 1)
                return ok().body(this.datasource1Service.getAllForDatasource1());
            else if(datasourceType == 2)
                return ok().body(this.datasource2Service.getAllForDatasource2());
            else
              return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getCache/{id}/{datasourceType}")
    public ResponseEntity<Mono<? extends Persistable>> getCache(@PathVariable Long id, @PathVariable int datasourceType) {
        try {
            if(datasourceType == 1)
                return ok().body(this.datasource1Service.getCacheByIdForDatasource1(id));
            else if(datasourceType == 2)
                return ok().body(this.datasource2Service.getCacheByIdForDatasource2(id));
            else
                return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/putCache/{id}/{datasourceType}")
    public ResponseEntity<Disposable> putCache(@RequestBody CustomerForDatasource1 object, @PathVariable String id, @PathVariable int datasourceType){
        CustomerForDatasource2 customersdata = new CustomerForDatasource2();
        customersdata.setFirstName(object.getFirstName());
        customersdata.setId(object.getId());
        customersdata.setLastName(object.getLastName());
        try {
            if(datasourceType == 1)
        return ok().body(this.datasource1Service.putCacheForDatasource1(object));
            else if(datasourceType == 2)
                return ok().body(this.datasource2Service.putCacheForDatasource2(customersdata));
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
