package com.MSResena.Soporte.Comunicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MSResena.Soporte.Comunicacion.model.RespuestaSoporte;

public interface respuestaRepository extends JpaRepository<RespuestaSoporte, Integer>{
    
}
