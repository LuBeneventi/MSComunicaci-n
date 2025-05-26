package com.MSResena.Soporte.Comunicacion.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MSResena.Soporte.Comunicacion.model.EstadoSoporte;
import com.MSResena.Soporte.Comunicacion.model.RespuestaSoporte;
import com.MSResena.Soporte.Comunicacion.model.solicitudSoporte;
import com.MSResena.Soporte.Comunicacion.repository.respuestaRepository;
import com.MSResena.Soporte.Comunicacion.repository.soporteRepository;

@Service
public class soporteService {
    @Autowired
    private soporteRepository sRepository;
    @Autowired
    private respuestaRepository rRepository;

    public solicitudSoporte crearSolicitud(solicitudSoporte sr) {
        sr.setFechaCreacion(LocalDate.now());
        sr.setEstado(EstadoSoporte.ABIERTA);
        return sRepository.save(sr);
    }

    public List<solicitudSoporte> listar() {
        return sRepository.findAll();
    }

    public Optional<solicitudSoporte> buscarPorId(int id) {
        return sRepository.findById(id);
    }

    public solicitudSoporte cerrar(int id) {
        solicitudSoporte soporte = sRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Soporte no encontrado"));
        soporte.setEstado(EstadoSoporte.CERRADA);
        return sRepository.save(soporte);
    }

    public RespuestaSoporte agregarRespuesta(int idSoporte, RespuestaSoporte respuesta) {
        solicitudSoporte soporte = sRepository.findById(idSoporte)
            .orElseThrow(() -> new RuntimeException("Soporte no encontrado"));

        respuesta.setFechaRespuesta(LocalDate.now());
        respuesta.setSoporte(soporte);
        RespuestaSoporte saved = rRepository.save(respuesta);

        soporte.setEstado(EstadoSoporte.RESPONDIDA);
        sRepository.save(soporte);

        return saved;
    }

    public List<solicitudSoporte> buscarPorCliente(int idCliente){
        return sRepository.findByIdCliente(idCliente);
    }

    public solicitudSoporte editaSoporte(solicitudSoporte ss){
        return crearSolicitud(ss);
    }

    public Boolean eliminarSolicitud(int id){
        solicitudSoporte ss = sRepository.findById(id).orElseThrow();
        if(sRepository.existsById(id) && ss.getEstado() != EstadoSoporte.RESPONDIDA){
            sRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
