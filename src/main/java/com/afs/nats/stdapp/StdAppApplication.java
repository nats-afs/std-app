package com.afs.nats.stdapp;

import java.util.ArrayList;
import java.util.List;

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
		return args -> {
			List<Claimant> claimantList = new ArrayList<Claimant>();
			for (int i = 1; i < 25; i++) {
				claimantList
				.add(new Claimant(
						String.format("Nombres %d",i), 
						String.format("Apellidos %d", i),
						String.format("Direccion %d", i),
						String.format("Telefono %d", i),
						String.format("foo%d@bas.com", i),
						TipoDocumento.DNI, 
						"98745678"));
			}
			claimantList.forEach(repository::save);
		};
	}

}
