package com.balabarca.pruebatecnica.repository;

import com.balabarca.pruebatecnica.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    @Query("SELECT p FROM Proyecto p WHERE " +
            "(:codigo IS NULL OR p.codigo LIKE %:codigo%) AND " +
            "(:nombre IS NULL OR p.nombre LIKE %:nombre%) AND " +
            "(:estado IS NULL OR p.estado LIKE %:estado%) AND " +
            "(:categoria IS NULL OR p.categoria LIKE %:categoria%) AND " +
            "(CAST(:fecha_inicio AS localdate) IS NULL OR p.fecha_inicio >= :fecha_inicio) AND " +
            "(CAST(:fecha_fin AS localdate) IS NULL OR p.fecha_fin <= :fecha_fin)")
    List<Proyecto> busquedaAvanzada(
            @Param("codigo") String codigo,
            @Param("nombre") String nombre,
            @Param("estado") String estado,
            @Param("categoria") String categoria,
            @Param("fecha_inicio") LocalDate fecha_inicio,
            @Param("fecha_fin") LocalDate fecha_fin
    );
}
