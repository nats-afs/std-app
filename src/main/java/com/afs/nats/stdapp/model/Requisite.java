package com.afs.nats.stdapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Requisite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@NotBlank(message="Indique nombre de requisito")
	private @NonNull String nombre;
	@NotNull
	@NotBlank(message="Indique descripcion de requisito")
	private @NonNull String descripcion;
	@ManyToMany
	@JoinTable(
			name= "Process_Requisite",
			joinColumns= {@JoinColumn(name="IdProcess")},
			inverseJoinColumns = {@JoinColumn(name = "IdRequisite")}
			)
	Set<Process> processes = new HashSet<Process>();
}
