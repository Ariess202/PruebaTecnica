package com.balabarca.pruebatecnica.repository;

import com.balabarca.pruebatecnica.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
