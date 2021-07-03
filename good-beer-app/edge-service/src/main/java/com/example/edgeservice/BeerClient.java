package com.example.edgeservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@FeignClient("BEER-CATALOG-SERVICE")
public interface BeerClient {

    @GetMapping(path = "/beers")
    @CrossOrigin
    CollectionModel<Beer> readBears();
}
