package com.example.beercatalogservere;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class BeerCatalogServereApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerCatalogServereApplication.class, args);
    }

    @Bean
    ApplicationRunner init(BeerRepository repository) {
        return args -> {
            Stream.of("Dreher Hidegkomlós", "Heineken", "Kőbányai", "Dreher IPA", "Staropramen", "gösser", "Rákoczi")
                    .forEach(beer -> repository.save(new Beer(beer)));

            repository.findAll().forEach(System.out::println);
        };
    }

}
