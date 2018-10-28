package com.afs.nats.stdapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Process {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private @NonNull String nombre;
	private @NonNull String descripcion;
	@ManyToOne
	@NotNull
	private @NonNull Tupa tupa;
	@NotNull
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name= "Process_Requisite",
			joinColumns= {@JoinColumn(name="IdProcess")},
			inverseJoinColumns = {@JoinColumn(name = "IdRequisite")}
			)
	private @NonNull Set<Requisite> requisites = new HashSet<Requisite>();
	
}
