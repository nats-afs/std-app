package com.afs.nats.stdapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afs.nats.stdapp.model.Process;
import com.afs.nats.stdapp.model.Requisite;

public interface RequisiteRepository extends JpaRepository<Requisite, Long> {

}
