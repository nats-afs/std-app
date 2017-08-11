package com.afs.nats.stdapp.model;

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
	private @NonNull String nombre;
	private @NonNull String email;
	private @NonNull String password;
	private @NonNull Boolean active;
	// @ManyToMany(cascade = CascadeType.ALL)
	// @JoinTable(name = "user_role", joinColumns = @JoinColumn(name =
	// "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	// @Enumerated(EnumType.STRING)
	// private @NonNull Set<Role> role;
	@Enumerated(EnumType.STRING)
	private @NonNull Role role;
}
