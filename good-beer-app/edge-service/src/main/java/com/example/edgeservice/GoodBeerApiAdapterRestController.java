package com.example.edgeservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class GoodBeerApiAdapterRestController {

    private final BeerClient beerClient;

    public GoodBeerApiAdapterRestController(BeerClient beerClient) {
        this.beerClient = beerClient;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @CrossOrigin
    @GetMapping("/good-beers")
    public Collection<Beer> goodBeers() {
        return beerClient.readBears()
                .getContent()
                .stream()
                .filter(this::isGreatBeer)
                .collect(Collectors.toList());
    }

    public Collection<Beer> fallback() {
        return new ArrayList<>();
    }

    private boolean isGreatBeer(Beer beer) {
        return beer.getName().equals("Dreher Hidegkomlós") ||
                beer.getName().equals("Kőbányai") ||
                beer.getName().equals("Staropramen");
    }


}
