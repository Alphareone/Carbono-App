package com.carbono2050.carbono_app.repository;

import com.carbono2050.carbono_app.model.Emision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmisionRepository extends JpaRepository<Emision, Long> {
}