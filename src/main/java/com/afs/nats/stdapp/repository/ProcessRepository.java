package com.afs.nats.stdapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afs.nats.stdapp.model.Process;

public interface ProcessRepository extends JpaRepository<Process, Long> {

}
