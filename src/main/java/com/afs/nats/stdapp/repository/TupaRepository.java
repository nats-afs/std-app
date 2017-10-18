package com.afs.nats.stdapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afs.nats.stdapp.model.Tupa;


@Repository
public interface TupaRepository extends JpaRepository<Tupa, Long> {

}
