package com.api.guilherme.portfolio.remedios.remedio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {

    List<Remedio> findAllByAtivoTrue();
}
