package com.afs.nats.stdapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afs.nats.stdapp.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	List<Company>findByEnable(Boolean enable);
}
