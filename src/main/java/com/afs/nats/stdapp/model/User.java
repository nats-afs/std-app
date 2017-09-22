package com.afs.nats.stdapp.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="Nombre de usuario requerido")
	private @NonNull String username;
	@NotEmpty(message="Password requerido")
	private @NonNull String password;
//	private @NonNull String password;
//	private @NonNull Boolean active;
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_role",
//		joinColumns = @JoinColumn(name = "userId"),
//		inverseJoinColumns = @JoinColumn(name = "roleId")
//	)
//	private @NonNull Set<User> users = new HashSet<User>();
}
