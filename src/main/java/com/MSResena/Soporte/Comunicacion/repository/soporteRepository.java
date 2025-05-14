package com.MSResena.Soporte.Comunicacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MSResena.Soporte.Comunicacion.model.solicitudSoporte;

@Repository
public interface soporteRepository extends JpaRepository<solicitudSoporte, Integer>{
    
    List<solicitudSoporte> findByIdCliente(int idCliente);
}
