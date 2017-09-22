package com.afs.nats.stdapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afs.nats.stdapp.model.Claimant;

public interface ClaimantRepository extends JpaRepository<Claimant, Long> {
	Claimant findByNroDoc(String nroDoc);
}
