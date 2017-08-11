package com.afs.nats.stdapp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Claimant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private @NonNull String nombres;
	private @NonNull String apellidos;
	private @NonNull String direccion;
	private @NonNull String telefono;
	private @NonNull String email;
	@Enumerated(EnumType.STRING)
	private @NonNull TipoDocumento doc;
	private @NonNull String nroDoc;
}
