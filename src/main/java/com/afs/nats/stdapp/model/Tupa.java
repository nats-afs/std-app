package com.afs.nats.stdapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Tupa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message="Indique año")
	private Integer anio;
	@NotEmpty(message ="Indique nombre")
	private @NonNull String nombre;
	@NotEmpty(message ="Indique resolución")
	private @NonNull String resolucion;
//	@OneToMany(mappedBy="tupa")
//	@Cascade(CascadeType.ALL)
//	private Set<Process> procedures = new HashSet<Process>();
}
