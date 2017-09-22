package com.afs.nats.stdapp.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Work {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@NotBlank(message="Indique compañia")
	private @NonNull Company company;
	@OneToOne
	@NotBlank(message="Indique TUPA")
	private @NonNull Tupa tupa;
	@NotBlank(message = "Ingrese valor de UIT para el año")
	private @NonNull BigDecimal uit;
}
