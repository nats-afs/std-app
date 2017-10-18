package com.afs.nats.stdapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Indique nombre")
	private @NonNull String nombre;
	@NotBlank(message = "Indique abreviatura")
	private @NonNull String abrev;
	@NotBlank(message = "Indique slogan")
	private @NonNull String slogan;
	@NotNull
	private boolean enable;
}
