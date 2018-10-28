package com.afs.nats.stdapp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.afs.nats.stdapp.model.Claimant;
import com.afs.nats.stdapp.model.TipoDocumento;
import com.afs.nats.stdapp.repository.ClaimantRepository;

@SpringBootApplication
public class StdAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StdAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner setData(ClaimantRepository repository) {
        Faker faker = new Faker();

        return args -> {
            IntStream.range(1, 100).forEach(n ->
                    repository.save(
                            new Claimant(
                                    faker.name().firstName(),
                                    faker.name().lastName(),
                                    faker.address().fullAddress(),
                                    faker.phoneNumber().cellPhone(),
                                    faker.internet().emailAddress(),
                                    TipoDocumento.DNI,
                                    faker.number().digits(8)
                            )
                    )
            );
        };
    }

}
