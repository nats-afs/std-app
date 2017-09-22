package com.afs.nats.stdapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afs.nats.stdapp.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
