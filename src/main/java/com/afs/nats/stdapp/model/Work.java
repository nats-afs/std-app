package com.afs.nats.stdapp.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
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
public class Work {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@NotNull(message = "Indique compañia")
	private @NonNull Company company;
	@OneToOne
	@NotNull(message = "Indique TUPA")
	private @NonNull Tupa tupa;
	@Digits(integer = 8, fraction = 2, message = "Numero fuera de estimacion")
	@DecimalMin(value = "0.00", inclusive = false, message = "Indique valor de UIT")
	private @NonNull BigDecimal uit;
}
