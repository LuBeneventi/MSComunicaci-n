package com.MSResena.Soporte.Comunicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MSResena.Soporte.Comunicacion.model.resena;

@Repository
public interface ReseñaRepository extends JpaRepository<resena, Integer>{

    
}