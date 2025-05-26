package com.MSResena.Soporte.Comunicacion.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MSResena.Soporte.Comunicacion.model.resena;
import com.MSResena.Soporte.Comunicacion.repository.ReseñaRepository;

@Service
public class resenaService {
    @Autowired
    private ReseñaRepository rRepo;

    public resena guardar(resena reseña) {
    if (reseña.getCalificacion() < 1 || reseña.getCalificacion() > 5) {
        throw new IllegalArgumentException("La calificación debe estar entre 1 y 5.");
    }
    reseña.setFechaEmision(LocalDate.now());
    return rRepo.save(reseña);
}

    public List<resena> listar() {
        return rRepo.findAll();
    }

    public List<resena> buscarPorProducto(int idProducto) {
        return rRepo.findByIdProducto(idProducto);
    }

    public Optional<resena> Buscar(int id){
        return rRepo.findById(id);
    }

    public List<resena> buscarPorCliente(int idCliente){
        return rRepo.findByIdCliente(idCliente);
    }

    public resena editar(int id, resena actualizada) {
        resena existente = rRepo.findById(id).orElseThrow();
        existente.setComentario(actualizada.getComentario());
        existente.setCalificacion(actualizada.getCalificacion());
        return guardar(existente);
    }

    public void eliminar(int id) {
        if (!rRepo.existsById(id)) {
            throw new RuntimeException("Reseña no encontrada con ID: " + id);
        }
        rRepo.deleteById(id);
    }
}
