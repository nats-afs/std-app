package com.afs.nats.stdapp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Claimant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Indique nombre de solicitante")
	private @NonNull String nombres;
	@NotBlank(message = "Indique apellidos de solicitante")
	private @NonNull String apellidos;
	@NotBlank(message = "Indique direccion de solicitante")
	private @NonNull String direccion;
	@Size(min = 7, message = "Telefono debe contener al menos 7 caracteres")
	private @NonNull String telefono;
	@Email(message = "Ingrese una direccion de email valida")
	@NotBlank(message = "Indique email de solicitante")
	@NotNull
	private @NonNull String email;
	@NotNull(message = "Indique Documento")
	@Enumerated(EnumType.STRING)
	private @NonNull TipoDocumento doc;
	@NotBlank(message = "Indique numero de documento")
	@Size(min = 8, max = 11, message = "Indique numero de documento de 8 a 11 caracteres")
	private @NonNull String nroDoc;
}
